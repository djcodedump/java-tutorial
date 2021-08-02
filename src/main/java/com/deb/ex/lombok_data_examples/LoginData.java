package com.deb.ex.lombok_data_examples;

import lombok.Data;
import lombok.Getter;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.experimental.Accessors;

import java.net.URL;

@RequiredArgsConstructor
@Data
@Accessors(fluent = true)
public class LoginData {
    private final @NonNull String authToken;
    private final @NonNull String userName;
}
