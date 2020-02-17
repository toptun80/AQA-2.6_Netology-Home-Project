package ru.netology.restassured;

import com.github.javafaker.Faker;
import com.github.javafaker.service.FakeValuesService;
import com.github.javafaker.service.RandomService;
import ru.netology.models.UserDataModel;

import java.util.*;

import static java.lang.String.join;

public class UserDataGenerator {

    public static class Registration {
        private Registration() {
        }

        public static UserDataModel generateValidData(String locale, int statusIndex) {
            Faker faker = new Faker(new Locale(locale));
            String login = faker.name().username();
            String password = faker.internet().password();
            List <String> statusList = Arrays.asList("blocked", "active");
            String status = statusList.get(statusIndex);
            return new UserDataModel(login, password, status);
        }
    }
}


