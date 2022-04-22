package ru.agser.server.security;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import ru.agser.server.exception.IllegalEmailStateException;
import ru.agser.server.exception.IncorrectPasswordException;

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

    public User signUpWorker(String email, String password) {
        userRepository.findUserByEmail(email).ifPresent(
                (u) -> {throw new IllegalEmailStateException("Данный email занят");}
        );

        return userRepository.save(
                User.builder()
                .email(email)
                .password(passwordEncoder.encode(password))
                .role(UserRole.WORKER)
                .build());

    }

    public User signIn(String email, String password) {

        User user = userRepository.findUserByEmail(email).orElseThrow(
                () -> new IllegalEmailStateException("Пользователь с таким email не найден")
        );

        if (!passwordEncoder.matches(password, user.getPassword())) {
            throw new IncorrectPasswordException("Введен неверный пароль");
        }

        return user;
    }

    public Boolean deleteById(Long id) {
        userRepository.deleteById(id);
        return true;
    }

    public User signUp(String email, String password) {
        userRepository.findUserByEmail(email).ifPresent(
                (u) -> {throw new IllegalEmailStateException("Данный email занят");}
        );

        return userRepository.save(new User.UserBuilder()
                .email(email)
                .password(passwordEncoder.encode(password))
                .role(UserRole.PARENT)
                .build());
    }
}
