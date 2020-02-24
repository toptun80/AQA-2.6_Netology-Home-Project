package ru.netology.restassured;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.netology.models.UserDataModel;

import static com.codeborne.selenide.Condition.text;
import static ru.netology.restassured.PageElements.*;

import static com.codeborne.selenide.Selenide.open;
import static ru.netology.restassured.UserDataGenerator.UserRegistration.setUpUser;

public class RestAssuredTest {

    @BeforeEach
    void setUp() {
        open("http://localhost:9999");
    }

    @Test
    void shouldLogInPersonalAccount() {
        UserDataModel userDataModel = setUpUser("en-US", 1);
        loginField.setValue(userDataModel.getLogin());
        passwordField.setValue(userDataModel.getPassword());
        buttonNext.click();
        personalAccount.shouldHave(text("Личный кабинет"));
    }

    @Test
    void shouldNotifyThatAccountIsBlocked() {
        UserDataModel userDataModel = setUpUser("en-US", 0);
        loginField.setValue(userDataModel.getLogin());
        passwordField.setValue(userDataModel.getPassword());
        buttonNext.click();
        notificationPopUp.shouldHave(text("Пользователь заблокирован"));
    }

    @Test
    void shouldNotifyThatLoginIsIncorrect() {
        loginField.setValue("fakeUser");
        passwordField.setValue("fakeUser");
        buttonNext.click();
        notificationPopUp.shouldHave(text("Неверно указан логин или пароль"));
    }

    @Test
    void shouldNotifyThatPasswordIsIncorrect() {
        UserDataModel userDataModel = setUpUser("en-US", 1);
        loginField.setValue(userDataModel.getLogin());
        passwordField.setValue(userDataModel.getPassword() + "fake");
        buttonNext.click();
        notificationPopUp.shouldHave(text("Неверно указан логин или пароль"));
    }
}