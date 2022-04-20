package ru.agser.server.security;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.agser.server.model.dto.Response;
import ru.agser.server.security.payload.SignInRequest;
import ru.agser.server.security.payload.SignUpRequest;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/api/v1/auth")
@CrossOrigin(origins = "http://localhost:3000")
public class AuthController {

    private final UserService userService;


    public AuthController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/signup-worker")
    public ResponseEntity<Response> registerUser(@RequestBody SignUpRequest signUpRequest) {
        System.out.println(signUpRequest);


        User user = userService.signUpWorker(signUpRequest.getEmail(), signUpRequest.getPassword());
        Map<?, ?> data;
        if (user != null) {
            data = Map.of("user", user, "success", true);
        } else {
            data = Map.of("user", "User already exists", "success", false);
        }
        return ResponseEntity.ok(
                Response.builder()
                        .timeStamp(LocalDateTime.now())
                        .message("worker signed up")
                        .status(HttpStatus.OK)
                        .statusCode(HttpStatus.OK.value())
                        .data(data)
                        .build());
    }

    @PostMapping("/signin")
    public ResponseEntity<Response> authenticateUser(@RequestBody SignInRequest signInRequest) {
        System.out.println(signInRequest);


        User user = userService.signIn(signInRequest.getEmail(), signInRequest.getPassword());
        Map<?, ?> data;
        if (user != null) {
            data = Map.of("user", user, "success", true);
        } else {
            data = Map.of("user", "Incorrect password or email", "success", false);
        }
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
