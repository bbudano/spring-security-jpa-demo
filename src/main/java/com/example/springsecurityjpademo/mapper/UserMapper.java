package com.example.springsecurityjpademo.mapper;

import com.example.springsecurityjpademo.dto.UserDto;
import com.example.springsecurityjpademo.dto.UserProfileDto;
import com.example.springsecurityjpademo.model.Role;
import com.example.springsecurityjpademo.model.User;
import org.mapstruct.*;

import java.util.List;
import java.util.stream.Collectors;

@Mapper(componentModel = "spring", injectionStrategy = InjectionStrategy.CONSTRUCTOR, unmappedTargetPolicy = ReportingPolicy.WARN)
public interface UserMapper {

    @Mapping(target = "roles", source = "roles", qualifiedByName = "mapRoleNames")
    @Mapping(target = "email", expression = "java(user.getUsername())")
    UserProfileDto toUserProfileDto(User user);

    @Mapping(target = "roles", source = "roles", qualifiedByName = "mapRoleNames")
    @Mapping(target = "email", expression = "java(user.getUsername())")
    UserDto toUserDto(User user);

    @Named("mapRoleNames")
    default List<String> mapRoleNames(List<Role> roles) {
        return roles
                .stream()
                .map(Role::getName)
                .collect(Collectors.toList());
    }

}
