package com.rafael.pizzeria.security.model.mapper;

import com.rafael.pizzeria.security.model.dto.UserDTO;
import com.rafael.pizzeria.security.model.entity.UserEntity;
import org.mapstruct.*;

@Mapper(componentModel = "spring", builder = @Builder(disableBuilder = true))
public interface IUserMapper {
    @Mappings({
            @Mapping(target = "username", source = "username"),
            @Mapping(target = "password", source = "password"),
            @Mapping(target = "role", source = "role"),
            @Mapping(target = "email", source = "email"),
            @Mapping(target = "locked", source = "locked"),
            @Mapping(target = "disabled", source = "disabled"),
            @Mapping(target = "name", source = "name")
    })
    UserEntity toEntity(UserDTO userDTO);
    @InheritConfiguration
    UserDTO toDTO(UserEntity userEntity);

}
