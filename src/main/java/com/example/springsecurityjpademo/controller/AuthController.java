package com.example.springsecurityjpademo.controller;

import com.example.springsecurityjpademo.dto.ChangePasswordRequest;
import com.example.springsecurityjpademo.dto.UserProfileDto;
import com.example.springsecurityjpademo.mapper.UserMapper;
import com.example.springsecurityjpademo.model.User;
import com.example.springsecurityjpademo.service.AuthService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/api/v1/auth")
@RequiredArgsConstructor
public class AuthController {

    private final AuthService authService;
    private final UserMapper userMapper;

    @GetMapping("/profile")
    public UserProfileDto getUserProfile(Authentication authentication) {
        var user = (User) authentication.getPrincipal();

        return userMapper.toUserProfileDto(user);
    }

    @PostMapping("/change-password")
    public void changePassword(Authentication authentication, @RequestBody ChangePasswordRequest changePasswordRequest) {
        var user = (User) authentication.getPrincipal();

        authService.changePassword(user, changePasswordRequest);
    }

}
