package ru.agser.server.security.payload;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class SignInRequest {
    private String email;
    private String password;
}
