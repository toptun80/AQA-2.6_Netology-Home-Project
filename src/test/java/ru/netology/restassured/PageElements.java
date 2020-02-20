package ru.netology.restassured;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$;

public class PageElements {
    static final SelenideElement body = $("body");
    static final SelenideElement form = $("form");
    static final SelenideElement loginField = form.$(".input__control[name=login]");
    static final SelenideElement passwordField = form.$(".input__control[name='password']");
    static final SelenideElement buttonNext = form.$(".button_size_m[data-test-id='action-login']");
}
