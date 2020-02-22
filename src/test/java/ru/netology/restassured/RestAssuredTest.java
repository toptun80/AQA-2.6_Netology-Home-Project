package ru.netology.restassured;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.netology.models.UserDataModel;
import static ru.netology.restassured.UserDataGenerator.AuthTest;
import static ru.netology.restassured.PageElements.*;

import static com.codeborne.selenide.Selenide.open;

public class RestAssuredTest {
    private UserDataModel userDataModel;

    @BeforeEach
    void setUp() {
        open("http://localhost:9999");
    }

    @Test
    void happyPathTest() {
        userDataModel = AuthTest.setUpUser("en-US", 1);
        loginField.setValue(userDataModel.getLogin());
        passwordField.setValue(userDataModel.getPassword());
        buttonNext.click();
    }
}