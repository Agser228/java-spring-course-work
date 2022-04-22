package ru.agser.server.security.payload;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Getter
@Setter
@ToString
public class AuthRequest {
    @Email(message = "Email в неправильном формате")
    @NotBlank(message = "Email не должен быть пустым")
    private String email;

    @Size(max=10,min=5,message="Длина пароля от 5 до 10 символов")
    private String password;
}
