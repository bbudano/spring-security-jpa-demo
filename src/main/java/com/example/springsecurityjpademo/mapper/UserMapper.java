package com.example.springsecurityjpademo.mapper;

import com.example.springsecurityjpademo.dto.CreateUserRequest;
import com.example.springsecurityjpademo.dto.UserDto;
import com.example.springsecurityjpademo.dto.UserProfileDto;
import com.example.springsecurityjpademo.model.User;
import org.mapstruct.InjectionStrategy;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring", injectionStrategy = InjectionStrategy.CONSTRUCTOR, unmappedTargetPolicy = ReportingPolicy.WARN)
public interface UserMapper {

    UserProfileDto toUserProfileDto(User user);

    UserDto toUserDto(User user);

    @Mapping(target = "authorities", ignore = true)
    @Mapping(target = "password", ignore = true)
    User toUser(CreateUserRequest createUserRequest);

}
