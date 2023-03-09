package com.example.springsecurityjpademo.service;

import com.example.springsecurityjpademo.dto.CreateUserRequest;
import com.example.springsecurityjpademo.dto.UserDto;
import com.example.springsecurityjpademo.mapper.UserMapper;
import com.example.springsecurityjpademo.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;

    private final UserMapper userMapper;

    private final PasswordEncoder passwordEncoder;

    @Transactional
    public UserDto createUser(CreateUserRequest createUserRequest) {
        var user = userMapper.toUser(createUserRequest);

        user.setPassword(passwordEncoder.encode(createUserRequest.getPassword()));

        userRepository.saveAndFlush(user);

        return userMapper.toUserDto(user);
    }

    @Transactional(readOnly = true)
    public Page<UserDto> getUsers(Pageable pageable) {
        return userRepository
                .findAll(pageable)
                .map(userMapper::toUserDto);
    }

    @Transactional(readOnly = true)
    public UserDto getUser(Long id) {
        var user = userRepository
                .findById(id)
                .orElseThrow(() -> new RuntimeException("User not found."));

        return userMapper.toUserDto(user);
    }

}
