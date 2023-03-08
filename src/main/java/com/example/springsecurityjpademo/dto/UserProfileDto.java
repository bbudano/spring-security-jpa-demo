package com.example.springsecurityjpademo.dto;

import com.example.springsecurityjpademo.model.User;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserProfileDto {

    private Long id;

    private String email;

    private User.Role role;

    private User.Status status;

}
