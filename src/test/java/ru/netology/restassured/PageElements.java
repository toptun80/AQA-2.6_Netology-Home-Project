package ru.netology.restassured;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$;

public class PageElements {
    static final SelenideElement root = $("#root");
    static final SelenideElement form = $("form");
    static final SelenideElement loginField = form.$(".input__control[name=login]");
    static final SelenideElement passwordField = form.$(".input__control[name='password']");
    static final SelenideElement buttonNext = form.$(".button_size_m[data-test-id='action-login']");
    static final SelenideElement personalAccount = root.$(".heading");
    static final SelenideElement notificationPopUp = root.$(".notification");
}