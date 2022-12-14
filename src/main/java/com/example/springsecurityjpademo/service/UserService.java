package com.example.springsecurityjpademo.service;

import com.example.springsecurityjpademo.dto.CreateOrUpdateUserRequest;
import com.example.springsecurityjpademo.model.User;
import com.example.springsecurityjpademo.repository.RoleRepository;
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

    private final RoleRepository roleRepository;

    private final PasswordEncoder passwordEncoder;

    @Transactional
    public User createUser(CreateOrUpdateUserRequest createUserRequest) {
        var user = new User();
        user.setEmail(createUserRequest.getEmail());
        user.setPassword(passwordEncoder.encode(createUserRequest.getPassword()));
        user.setStatus(createUserRequest.getStatus());
        userRepository.save(user);

        createUserRequest.getRoles().forEach(roleId -> {
            var role = roleRepository
                    .findById(roleId)
                    .orElseThrow(() -> new RuntimeException("Role not found."));

            user.getRoles().add(role);
        });

        return userRepository.saveAndFlush(user);
    }

    @Transactional(readOnly = true)
    public Page<User> getUsers(Pageable pageable) {
        return userRepository.findAll(pageable);
    }

    @Transactional(readOnly = true)
    public User getUser(Long id) {
        return userRepository
                .findById(id)
                .orElseThrow(() -> new RuntimeException("User not found."));
    }

    @Transactional
    public User updateUser(Long id, CreateOrUpdateUserRequest updateUserRequest) {
        var user = getUser(id);

        user.setEmail(updateUserRequest.getEmail());
        user.setPassword(passwordEncoder.encode(updateUserRequest.getPassword()));
        user.setStatus(updateUserRequest.getStatus());

        updateUserRequest.getRoles().forEach(roleId -> {
            var role = roleRepository
                    .findById(roleId)
                    .orElseThrow(() -> new RuntimeException("Role not found."));

            user.getRoles().add(role);
        });

        return user;
    }



}
