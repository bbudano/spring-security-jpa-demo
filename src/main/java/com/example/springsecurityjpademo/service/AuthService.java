package com.example.springsecurityjpademo.service;

import com.example.springsecurityjpademo.dto.ChangePasswordRequest;
import com.example.springsecurityjpademo.model.User;
import com.example.springsecurityjpademo.repository.UserRepository;
import com.example.springsecurityjpademo.session.RedisSessionHandler;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import jakarta.servlet.http.HttpServletRequest;

@Slf4j
@Service
@RequiredArgsConstructor
public class AuthService {

    private final UserRepository userRepository;

    private final PasswordEncoder passwordEncoder;

    private final RedisSessionHandler redisSessionHandler;

    public void changePassword(User user, ChangePasswordRequest changePasswordRequest) {
        if (!passwordEncoder.matches(changePasswordRequest.getCurrentPassword(), user.getPassword())) {
            log.warn("Change password request ignored: Non-matching current password for user - {}", user.getUsername());
            return;
        }

        if (!changePasswordRequest.getNewPassword().equals(changePasswordRequest.getConfirmedNewPassword())) {
            log.warn("Change password request ignored: new password and confirmed new password do not match");
            return;
        }

        user.setPassword(passwordEncoder.encode(changePasswordRequest.getNewPassword()));
        userRepository.save(user);

        redisSessionHandler.removeAllUserSessions(user.getUsername());
    }

    public void logout(User user, HttpServletRequest httpServletRequest) {
        redisSessionHandler.removeUserSession(user.getUsername(), httpServletRequest.getSession().getId());
    }

}
