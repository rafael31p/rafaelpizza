package com.rafael.pizzeria.security.model.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "user")
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class UserEntity {
    @Id
    @Column(name = "username",nullable = false, unique = true, length = 20)
    private String username;
    @Column(nullable = false, length = 200)
    private String password;
    @Column(nullable = false, length = 20)
    private String role;
    @Column(nullable = false, length = 50)
    private String email;
    @Column(nullable = false, columnDefinition = "TINYINT")
    private Boolean locked;
    @Column(nullable = false, columnDefinition = "TINYINT")
    private Boolean disabled;
    @Column(name = "user_name", nullable = false, length = 50)
    private String name;

    @OneToMany(mappedBy = "userEntity", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private UserRoleEntity userRoleEntity;

    public UserRoleEntity getUserRoleEntity() {
        return userRoleEntity;
    }

    public void setUserRoleEntity(UserRoleEntity userRoleEntity) {
        this.userRoleEntity = userRoleEntity;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Boolean getLocked() {
        return locked;
    }

    public void setLocked(Boolean locked) {
        this.locked = locked;
    }

    public Boolean getDisabled() {
        return disabled;
    }

    public void setDisabled(Boolean disabled) {
        this.disabled = disabled;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
