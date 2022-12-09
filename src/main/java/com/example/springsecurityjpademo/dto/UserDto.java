package com.example.springsecurityjpademo.dto;

import com.example.springsecurityjpademo.model.User;
import lombok.Data;

import java.util.List;

@Data
public class UserDto {

    private String email;

    private User.Status status;

    private List<String> roles;

}
