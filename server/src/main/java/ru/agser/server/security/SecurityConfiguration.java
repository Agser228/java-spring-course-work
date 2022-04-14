package ru.agser.server.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

import java.security.Permission;

import static ru.agser.server.security.UserPermission.*;
import static ru.agser.server.security.UserRole.*;

@Configuration
@EnableWebSecurity
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {

    private final PasswordEncoder passwordEncoder;

    public SecurityConfiguration(PasswordEncoder passwordEncoder) {
        this.passwordEncoder = passwordEncoder;
    }


    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .csrf().disable()
                .authorizeRequests()
//                .antMatchers(HttpMethod.POST, "/api/v1/child/**").hasAuthority(CHILD_WRITE.getPermission())
//                .antMatchers(HttpMethod.GET, "/api/v1/child/**").hasAuthority(CHILD_READ.getPermission())
//                .antMatchers(HttpMethod.POST, "/api/v1/squad/**").hasAuthority(SQUAD_WRITE.getPermission())
//                .antMatchers(HttpMethod.GET, "/api/v1/squad/**").hasAuthority(SQUAD_READ.getPermission())
//                .antMatchers("/api/v1/**").hasRole(ADMIN.name())

                .anyRequest()
                .authenticated()
                .and()
                .httpBasic();
    }

    @Override
    @Bean
    protected UserDetailsService userDetailsService() {
        UserDetails userAdmin = User.builder()
                .username("admin")
                .password(passwordEncoder.encode("admin"))
//                .roles(ADMIN.name()) // ROLE_ADMIN
                .authorities(ADMIN.getGrantedAuthorities())
                .build();

        UserDetails userParent = User.builder()
                .username("parent")
                .password(passwordEncoder.encode("parent"))
//                .roles(PARENT.name()) // ROLE_PARENT
                .authorities(PARENT.getGrantedAuthorities())
                .build();

        UserDetails userCounselor = User.builder()
                .username("counselor")
                .password(passwordEncoder.encode("counselor"))
//                .roles(COUNSELOR.name()) // ROLE_COUNSELOR
                .authorities(COUNSELOR.getGrantedAuthorities())
                .build();

        return new InMemoryUserDetailsManager(
                userAdmin,
                userParent,
                userCounselor
        );
    }
}
