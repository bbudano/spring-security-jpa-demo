package com.example.springsecurityjpademo.controller;

import com.example.springsecurityjpademo.dto.RoleDto;
import com.example.springsecurityjpademo.mapper.RoleMapper;
import com.example.springsecurityjpademo.service.RoleService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping(path = "/api/v1/roles")
@RequiredArgsConstructor
public class RoleController {

    private final RoleService roleService;
    private final RoleMapper roleMapper;

    @GetMapping
    public List<RoleDto> getRoles() {
        return roleService
                .getRoles()
                .stream()
                .map(roleMapper::toRoleDto)
                .collect(Collectors.toList());
    }

}
