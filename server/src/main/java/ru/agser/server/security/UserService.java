package ru.agser.server.security;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import ru.agser.server.security.payload.SignInRequest;
import ru.agser.server.security.payload.SignUpRequest;

import java.sql.Date;
import java.time.LocalDate;

@Service
public class UserService implements UserDetailsService {

    private final UserRepository userRepository;
    private final PasswordEncoder encoder;
//    private final AuthenticationManager authenticationManager;

    public UserService(UserRepository userRepository,
                       PasswordEncoder encoder) {
        this.userRepository = userRepository;
        this.encoder = encoder;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return null;
    }

    public User signUp(SignUpRequest signUpRequest) {

        User user = User.builder()
                .username(signUpRequest.getUsername())
                .password(encoder.encode(signUpRequest.getPassword()))
                .build();

        return userRepository.save(user);
    }

    public User signIn(SignInRequest signInRequest) {
//        Authentication authentication = authenticationManager.authenticate(
//                new UsernamePasswordAuthenticationToken(
//                        signInRequest.getEmail(),
//                        signInRequest.getPassword()));
//
//        SecurityContextHolder.getContext().setAuthentication(authentication);
//
//        String key = "key";
//
//        String token = Jwts.builder()
//                .setSubject(authentication.getName())
//                .claim("authorities", authentication.getAuthorities())
//                .setExpiration(Date.valueOf(LocalDate.now().plusWeeks(2)))
//                .signWith(Keys.hmacShaKeyFor(key.getBytes()))
//                .compact();
//
//
        return new User();
    }
}
