package com.rafael.pizzeria.security.service;

import com.rafael.pizzeria.security.model.dto.UserDTO;

public interface IGestionUsersService {
    String saveUser(UserDTO userDTO);

    String eliminarUsuario(UserDTO userDTO);

    UserDTO actualizarUsuario(UserDTO userDTO);

    UserDTO buscarUsuario(UserDTO userDTO);
}
