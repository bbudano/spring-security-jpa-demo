package com.example.springsecurityjpademo.service;

import com.example.springsecurityjpademo.dto.UserProfileDto;
import com.example.springsecurityjpademo.model.Role;
import com.example.springsecurityjpademo.model.User;
import com.example.springsecurityjpademo.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class UserService implements UserDetailsService {

    private final UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return userRepository
                .findByEmail(username)
                .orElseThrow(() -> new UsernameNotFoundException("Username not found: " + username));
    }

    public UserProfileDto getUserProfile(User user) {
        return new UserProfileDto(
                user.getId(),
                user.getUsername(),
                user.getRoles().stream().map(Role::getName).collect(Collectors.toList()),
                user.getStatus()
        );
    }

}
