package com.example.springsecurityjpademo.controller;

import com.example.springsecurityjpademo.dto.CreateRoleRequest;
import com.example.springsecurityjpademo.dto.RoleDto;
import com.example.springsecurityjpademo.mapper.RoleMapper;
import com.example.springsecurityjpademo.service.RoleService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping(path = "/api/v1/roles")
@RequiredArgsConstructor
public class RoleController {

    private final RoleService roleService;
    private final RoleMapper roleMapper;

    @PostMapping
    public ResponseEntity<RoleDto> createRole(@RequestBody CreateRoleRequest createRoleRequest) {
        var role = roleService.createRole(createRoleRequest);

        var location = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(role.getId())
                .toUri();

        return ResponseEntity
                .created(location)
                .body(roleMapper.toRoleDto(role));
    }

    @GetMapping
    public List<RoleDto> getRoles() {
        return roleService
                .getRoles()
                .stream()
                .map(roleMapper::toRoleDto)
                .collect(Collectors.toList());
    }

}
