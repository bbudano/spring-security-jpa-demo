package com.example.springsecurityjpademo.controller;

import com.example.springsecurityjpademo.dto.UserProfileDto;
import com.example.springsecurityjpademo.mapper.UserMapper;
import com.example.springsecurityjpademo.model.User;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/api/v1/auth")
@RequiredArgsConstructor
public class AuthController {

    private final UserMapper userMapper;

    @GetMapping("/profile")
    public ResponseEntity<UserProfileDto> getUserProfile(Authentication authentication) {
        var user = (User) authentication.getPrincipal();

        return ResponseEntity
                .ok()
                .body(userMapper.toUserProfileDto(user));
    }

}
