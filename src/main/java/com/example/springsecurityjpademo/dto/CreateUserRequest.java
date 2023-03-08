package com.example.springsecurityjpademo.dto;

import com.example.springsecurityjpademo.model.User;
import lombok.Data;

@Data
public class CreateUserRequest {

    private String email;

    private String password;

    private User.Role role;

    private User.Status status;

}
