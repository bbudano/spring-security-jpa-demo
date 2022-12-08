package com.example.springsecurityjpademo.service;

import com.example.springsecurityjpademo.dto.UserProfileDto;
import com.example.springsecurityjpademo.mapper.UserMapper;
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

    private final UserMapper userMapper;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return userRepository
                .findByEmail(username)
                .orElseThrow(() -> new UsernameNotFoundException("Username not found: " + username));
    }

    public UserProfileDto getUserProfile(User user) {
        return userMapper.toUserProfileDto(user);
    }

}
