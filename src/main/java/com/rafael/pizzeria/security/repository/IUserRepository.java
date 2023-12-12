package com.rafael.pizzeria.security.repository;

import com.rafael.pizzeria.security.model.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IUserRepository extends JpaRepository<UserEntity, String> {

}
