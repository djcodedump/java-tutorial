package com.deb.ex.lombok_data_examples;

import lombok.*;
import lombok.experimental.Accessors;

@Data
@AllArgsConstructor
@RequiredArgsConstructor
public class Customer {
    private Long id;
    private String name;
    private String password;
    private String email;
}
