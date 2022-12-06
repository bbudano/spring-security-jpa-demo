package com.example.springsecurityjpademo.controller;

import com.example.springsecurityjpademo.dto.UserProfileDto;
import com.example.springsecurityjpademo.model.User;
import com.example.springsecurityjpademo.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/api/v1/users")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @GetMapping("/profile")
    public ResponseEntity<UserProfileDto> getUserProfile(Authentication authentication) {
        User user = (User) authentication.getPrincipal();

        return ResponseEntity
                .ok()
                .body(userService.getUserProfile(user));
    }

}
