package ru.agser.server.security;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.agser.server.security.payload.SignInRequest;
import ru.agser.server.security.payload.SignUpRequest;

@RestController
@RequestMapping("/api/v1/auth")
@CrossOrigin(origins = "http://localhost:3000")
public class AuthController {

    private final UserService userService;


    public AuthController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/signup")
    public ResponseEntity<?> registerUser(@RequestBody SignUpRequest signUpRequest) {
        System.out.println(signUpRequest);


        User signedUpUser = userService.signUp(signUpRequest);

        return ResponseEntity
                .ok()
                .body(signUpRequest);
    }

    @PostMapping("/signin")
    public ResponseEntity<?> authenticateUser(@RequestBody SignInRequest signInRequest) {
        System.out.println(signInRequest);


        User signedInUser = userService.signIn(signInRequest);

        return ResponseEntity
                .ok()
                .body(signInRequest);
    }

}
