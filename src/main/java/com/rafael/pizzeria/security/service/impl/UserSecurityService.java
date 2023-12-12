package com.rafael.pizzeria.security.service.impl;

import com.rafael.pizzeria.security.model.entity.UserEntity;
import com.rafael.pizzeria.security.model.mapper.IUserMapper;
import com.rafael.pizzeria.security.repository.IUserRepository;
import com.rafael.pizzeria.security.service.IUserSecurityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.web.context.annotation.ApplicationScope;

@Service
@ApplicationScope
public class UserSecurityService implements IUserSecurityService {
    private final IUserRepository userRepository;
    private final IUserMapper userMapper;
    @Autowired
    public UserSecurityService(IUserRepository userRepository, IUserMapper userMapper) {
        this.userRepository = userRepository;
        this.userMapper = userMapper;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        UserEntity userEntity = userRepository.findById(username)
                .orElseThrow(() -> new UsernameNotFoundException("User "+ username + " not found"));

        return User.builder()
                .username(userEntity.getUsername())
                .password(userEntity.getPassword())
                .roles(userEntity.getRole())
                .accountLocked(userEntity.getLocked())
                .disabled(userEntity.getDisabled())
                .build();
    }
}
