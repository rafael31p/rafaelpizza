package com.rafael.pizzeria.security.web.controller;

import com.rafael.pizzeria.security.model.dto.UserDTO;
import com.rafael.pizzeria.security.service.IGestionUsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/Api/gestionUser")
public class GestionUserController {
    private final IGestionUsersService userService;
    @Autowired
    public GestionUserController(IGestionUsersService userService) {
        this.userService = userService;
    }

    @PostMapping("/saveUser")
    public ResponseEntity<String> saveUser(@RequestBody UserDTO userDTO){
        return ResponseEntity.ok(userService.saveUser(userDTO));
    }
    @DeleteMapping("/eliminarUsuario")
    public ResponseEntity<String> eliminarUsuario(@RequestBody UserDTO userDTO){
        return ResponseEntity.ok(userService.eliminarUsuario(userDTO));
    }
    @PutMapping("/actualizarUsuario")
    public ResponseEntity<UserDTO> actualizarUsuario(@RequestBody UserDTO userDTO){
        return ResponseEntity.ok(userService.actualizarUsuario(userDTO));
    }
    @PutMapping("/buscarUsuario")
    public ResponseEntity<UserDTO> buscarUsuario(@RequestBody UserDTO userDTO){
        return ResponseEntity.ok(userService.buscarUsuario(userDTO));
    }
}
