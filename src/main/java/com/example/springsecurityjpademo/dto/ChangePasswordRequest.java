package com.example.springsecurityjpademo.dto;

import lombok.Data;

@Data
public class ChangePasswordRequest {

    private String currentPassword;

    private String newPassword;

    private String confirmedNewPassword;

}
