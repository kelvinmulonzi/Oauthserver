package com.example.oauthserver.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.Set;

@Component
public class DataInitializer implements CommandLineRunner {

    @Autowired
    private UserService userService;

    @Override
    public void run(String... args) throws Exception {
        // Create default users if they don't exist
        if (!userService.existsByUsername("user")) {
            userService.createUser("user", "user@example.com", "password", Set.of(Role.USER));
        }

        if (!userService.existsByUsername("admin")) {
            userService.createUser("admin", "admin@example.com", "admin123", Set.of(Role.ADMIN, Role.USER));
        }

        if (!userService.existsByUsername("moderator")) {
            userService.createUser("moderator", "mod@example.com", "mod123", Set.of(Role.MODERATOR, Role.USER));
        }
    }
}
