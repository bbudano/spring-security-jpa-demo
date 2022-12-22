package com.example.springsecurityjpademo.service;

import com.example.springsecurityjpademo.model.Role;
import com.example.springsecurityjpademo.repository.RoleRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class RoleService {

    private final RoleRepository roleRepository;

    public List<String> getRoles() {
        return roleRepository
                .findAll()
                .stream()
                .map(Role::getName)
                .collect(Collectors.toList());
    }

}
