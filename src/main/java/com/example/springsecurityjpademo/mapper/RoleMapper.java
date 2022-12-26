package com.example.springsecurityjpademo.mapper;

import com.example.springsecurityjpademo.dto.RoleDto;
import com.example.springsecurityjpademo.model.Role;
import org.mapstruct.InjectionStrategy;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring", injectionStrategy = InjectionStrategy.CONSTRUCTOR, unmappedTargetPolicy = ReportingPolicy.WARN)
public interface RoleMapper {

    RoleDto toRoleDto(Role role);

}
