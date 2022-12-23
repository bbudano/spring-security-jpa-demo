package com.example.springsecurityjpademo.service;

import com.example.springsecurityjpademo.dto.CreateRoleRequest;
import com.example.springsecurityjpademo.mapper.RoleMapper;
import com.example.springsecurityjpademo.model.Role;
import com.example.springsecurityjpademo.repository.RoleRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class RoleService {

    private final RoleRepository roleRepository;

    @Transactional
    public Role createRole(CreateRoleRequest createRoleRequest) {
        var role = new Role(createRoleRequest.getName());

        roleRepository.saveAndFlush(role);

        return role;
    }

    @Transactional(readOnly = true)
    public List<Role> getRoles() {
        return roleRepository.findAll();
    }

}
