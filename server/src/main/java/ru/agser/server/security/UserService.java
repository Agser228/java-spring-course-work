package ru.agser.server.security;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import ru.agser.server.security.payload.SignInRequest;
import ru.agser.server.security.payload.SignUpRequest;

@Service
public class UserService implements UserDetailsService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
//    private final AuthenticationManager authenticationManager;

    public UserService(UserRepository userRepository,
                       PasswordEncoder encoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = encoder;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return null;
    }

    public User signUp(SignUpRequest signUpRequest) {

        User user = User.builder()
                .email(signUpRequest.getUsername())
                .password(passwordEncoder.encode(signUpRequest.getPassword()))
                .build();

        return userRepository.save(user);
    }

    public User signIn(SignInRequest signInRequest) {
        String email = signInRequest.getEmail();
        String password = signInRequest.getPassword();

        User user = userRepository.findUserByEmail(email);

        System.out.println(String.format("Пользователь %s по email: %s", user, email));

        System.out.println(passwordEncoder.matches("1234", passwordEncoder.encode("1234")));

        if (passwordEncoder.matches(password, user.getPassword())) {
            System.out.println("Пароль совпал");
            return user;
        } else {
            System.out.println("Пароль не совпал");
            return null;
        }
    }
}
