package com.deb.ex.lombok_data_examples;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NonNull;
import lombok.ToString;
import lombok.experimental.Accessors;

@Data
@Accessors(fluent = true)
@ToString(exclude = {"userName"})
@EqualsAndHashCode(of = {"authToken"})
public class LoginData {
    private final @NonNull String authToken;
    private final @NonNull String userName;
}
