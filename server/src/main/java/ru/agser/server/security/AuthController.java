package ru.agser.server.security;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.agser.server.model.dto.Response;
import ru.agser.server.security.payload.AuthRequest;

import javax.validation.Valid;
import java.time.LocalDateTime;
import java.util.Map;

@RestController
@RequestMapping("/api/v1/auth")
@CrossOrigin(origins = "http://localhost:3000")
public class AuthController {

    private final UserService userService;

    public AuthController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/signup")
    public ResponseEntity<Response> signUpUser(@Valid @RequestBody AuthRequest signUpRequest) {
        User user = userService.signUp(signUpRequest.getEmail(), signUpRequest.getPassword());
        Map<?, ?> data = Map.of("user", user, "success", true);

        return ResponseEntity.ok(
                Response.builder()
                        .timeStamp(LocalDateTime.now())
                        .message("user logged")
                        .status(HttpStatus.OK)
                        .statusCode(HttpStatus.OK.value())
                        .data(data)
                        .build());
    }

    @PostMapping("/signin")
    public ResponseEntity<Response> signInUser(@Valid @RequestBody AuthRequest signInRequest) {
        User user = userService.signIn(signInRequest.getEmail(), signInRequest.getPassword());
        Map<?, ?> data = Map.of("user", user, "success", true);

        return ResponseEntity.ok(
                Response.builder()
                        .timeStamp(LocalDateTime.now())
                        .message("user logged")
                        .status(HttpStatus.OK)
                        .statusCode(HttpStatus.OK.value())
                        .data(data)
                        .build());
    }

}
