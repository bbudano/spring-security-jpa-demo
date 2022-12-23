package com.example.springsecurityjpademo.mapper;

import com.example.springsecurityjpademo.dto.CreateRoleRequest;
import com.example.springsecurityjpademo.dto.RoleDto;
import com.example.springsecurityjpademo.dto.UserProfileDto;
import com.example.springsecurityjpademo.model.Role;
import com.example.springsecurityjpademo.model.User;
import org.mapstruct.InjectionStrategy;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring", injectionStrategy = InjectionStrategy.CONSTRUCTOR, unmappedTargetPolicy = ReportingPolicy.WARN)
public interface RoleMapper {

    RoleDto toRoleDto(Role role);

}
