package ru.agser.server.security;

import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserRepositoryInit implements CommandLineRunner {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    public UserRepositoryInit(UserRepository userRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public void run(String... args) throws Exception {
        User admin = User.builder()
                .password(passwordEncoder.encode("admin"))
                .email("admin@mail.com")
                .role(UserRole.ADMIN)
                .build();

        User worker = User.builder()
                .password(passwordEncoder.encode("worker"))
                .email("worker@mail.com")
                .role(UserRole.WORKER)
                .build();

        User parent = User.builder()
                .password(passwordEncoder.encode("parent"))
                .email("parent@mail.com")
                .role(UserRole.PARENT)
                .build();

        userRepository.save(admin);
        userRepository.save(worker);
        userRepository.save(parent);

    }
}
