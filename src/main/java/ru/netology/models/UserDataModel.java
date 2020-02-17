package ru.netology.models;

import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
public class UserDataModel {
    private final String login;
    private final String password;
    private final String status;
}