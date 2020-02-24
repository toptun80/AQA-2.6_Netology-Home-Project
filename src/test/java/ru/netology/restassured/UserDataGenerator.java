package ru.netology.restassured;

import com.github.javafaker.Faker;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.filter.log.LogDetail;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import ru.netology.endpoints.EndPoint;
import ru.netology.models.UserDataModel;

import java.util.*;

import static io.restassured.RestAssured.given;

public class UserDataGenerator {

    public static class NewUserData {
        private NewUserData() {
        }

        public static UserDataModel generateUser(String locale, int statusIndex) {
            Faker faker = new Faker(new Locale(locale));
            String login = faker.name().username();
            String password = faker.internet().password();
            List<String> statusList = Arrays.asList("blocked", "active");
            String status = statusList.get(statusIndex);
            return new UserDataModel(login, password, status);
        }
    }

    public static class UserRegistration {

        private UserRegistration() {
        }

        static RequestSpecification requestSpec = new RequestSpecBuilder()
                .setBaseUri("http://localhost")
                .setPort(9999)
                .setAccept(ContentType.JSON)
                .setContentType(ContentType.JSON)
                .log(LogDetail.ALL)
                .build();

        static UserDataModel setUpUser(String locale, int statusIndex) {
            UserDataModel userDataModel = NewUserData.generateUser(locale, statusIndex);
            // сам запрос
            given() // "дано"
                    .spec(requestSpec) // указываем, какую спецификацию используем
                    .body(userDataModel) // передаём в теле объект, который будет преобразован в JSON
                    .when() // "когда"
                    .post(new EndPoint().getEndPoint()) // на какой путь, относительно BaseUri отправляем запрос
                    .then() // "тогда ожидаем"
                    .statusCode(200); // код 200 OK
            return userDataModel;
        }
    }
}