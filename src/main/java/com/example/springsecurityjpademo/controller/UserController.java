package com.example.springsecurityjpademo.controller;

import com.example.springsecurityjpademo.dto.CreateOrUpdateUserRequest;
import com.example.springsecurityjpademo.dto.UserDto;
import com.example.springsecurityjpademo.dto.UserProfileDto;
import com.example.springsecurityjpademo.mapper.UserMapper;
import com.example.springsecurityjpademo.model.User;
import com.example.springsecurityjpademo.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

@RestController
@RequestMapping(path = "/api/v1/users")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    private final UserMapper userMapper;

    @GetMapping("/profile")
    public ResponseEntity<UserProfileDto> getUserProfile(Authentication authentication) {
        var user = (User) authentication.getPrincipal();

        return ResponseEntity
                .ok()
                .body(userMapper.toUserProfileDto(user));
    }

    @PostMapping
    public ResponseEntity<UserDto> createUser(@RequestBody CreateOrUpdateUserRequest createUserRequest) {
        var user = userService.createUser(createUserRequest);

        var location = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(user.getId())
                .toUri();

        return ResponseEntity
                .created(location)
                .body(userMapper.toUserDto(user));
    }

    @GetMapping
    public ResponseEntity<Page<UserDto>> getUsers(Pageable pageable) {
        return ResponseEntity
                .ok()
                .body(userService
                        .getUsers(pageable)
                        .map(userMapper::toUserDto));
    }

    @GetMapping("/{id}")
    public ResponseEntity<UserDto> getUser(@PathVariable Long id) {
        var user = userService.getUser(id);

        return ResponseEntity
                .ok()
                .body(userMapper.toUserDto(user));
    }

    @PutMapping("/{id}")
    public ResponseEntity<UserDto> updateUser(@PathVariable Long id,
                                              @RequestBody CreateOrUpdateUserRequest updateUserRequest) {
        var user = userService.updateUser(id, updateUserRequest);

        return ResponseEntity
                .ok()
                .body(userMapper.toUserDto(user));
    }

}
