package com.example.springsecurityjpademo.mapper;

import com.example.springsecurityjpademo.dto.UserDto;
import com.example.springsecurityjpademo.dto.UserProfileDto;
import com.example.springsecurityjpademo.model.User;
import org.mapstruct.InjectionStrategy;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring", injectionStrategy = InjectionStrategy.CONSTRUCTOR, unmappedTargetPolicy = ReportingPolicy.WARN)
public interface UserMapper {

    @Mapping(target = "email", expression = "java(user.getUsername())")
    UserProfileDto toUserProfileDto(User user);

    @Mapping(target = "email", expression = "java(user.getUsername())")
    UserDto toUserDto(User user);

}
