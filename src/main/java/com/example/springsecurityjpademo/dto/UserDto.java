package com.example.springsecurityjpademo.dto;

import com.example.springsecurityjpademo.model.User;
import lombok.Data;

@Data
public class UserDto {

    private Long id;

    private String email;

    private String password;

    private User.Status status;

    private User.Role role;

}
