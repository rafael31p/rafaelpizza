package com.rafael.pizzeria.security.service.impl;

import com.rafael.pizzeria.exceptions.CustomException;
import com.rafael.pizzeria.security.model.dto.UserDTO;
import com.rafael.pizzeria.security.model.entity.UserEntity;
import com.rafael.pizzeria.security.model.mapper.IUserMapper;
import com.rafael.pizzeria.security.repository.IUserRepository;
import com.rafael.pizzeria.security.service.IGestionUsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.context.annotation.ApplicationScope;

@Service
@ApplicationScope
public class GestionUserService implements IGestionUsersService {
    private final IUserRepository userRepository;
    private final IUserMapper userMapper;
    private final PasswordEncoder passwordEncoder;
    @Autowired
    public GestionUserService(IUserRepository userRepository, IUserMapper userMapper, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.userMapper = userMapper;
        this.passwordEncoder = passwordEncoder;
    }
    @Override
    public String saveUser(UserDTO userDTO) {
        validarUsuarioExistente(userDTO);
        UserEntity userEntity = userMapper.toEntity(userDTO);
        userEntity.setPassword(passwordEncoder.encode(userEntity.getPassword()));
        userRepository.save(userEntity);
        return "Usuario creado";
    }

    private Boolean validarUsuario(UserDTO userDTO) {
        return userRepository.existsById(userDTO.getUsername());
    }
    @Override
    public String eliminarUsuario(UserDTO userDTO) {
        userRepository.deleteById(userDTO.getUsername());
        return "Usuario eliminado";
    }
    @Override
    public UserDTO actualizarUsuario(UserDTO userDTO) {
        return userMapper.toDTO(userRepository.save(userMapper.toEntity(userDTO)));
    }
    @Override
    public UserDTO buscarUsuario(UserDTO userDTO) {
        return userMapper.toDTO(userRepository.findById(userDTO.getUsername())
                .orElseThrow(() -> new CustomException("El usuario no existe")));
    }
    private void validarUsuarioExistente(UserDTO userDTO) {
        if (validarUsuario(userDTO)) {
            throw new CustomException("El usuario ya existe");
        }
    }

}
