package ru.agser.server.security.payload;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.Set;

@Getter
@Setter
@ToString
public class SignUpRequest {
    private String username;
    private String email;
    private String password;
    private Set<String> roles;
}
