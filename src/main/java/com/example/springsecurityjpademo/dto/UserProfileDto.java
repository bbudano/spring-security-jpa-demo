package com.example.springsecurityjpademo.dto;

import com.example.springsecurityjpademo.model.User;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserProfileDto {

    private Long id;

    private String email;

    private List<String> roles;

    private User.Status status;

}
