package ru.netology.endpoints;

import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
public final class EndPoint {
    private final String endPoint = "/api/system/users";
}