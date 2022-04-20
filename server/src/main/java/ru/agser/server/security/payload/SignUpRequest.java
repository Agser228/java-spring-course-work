package ru.agser.server.security.payload;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class SignUpRequest {
    private String email;
    private String password;
}
