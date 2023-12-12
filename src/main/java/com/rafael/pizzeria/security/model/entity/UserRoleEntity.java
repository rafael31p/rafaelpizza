package com.rafael.pizzeria.security.model.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.time.LocalDateTime;

@Entity
@Table(name = "user_role")
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UserRoleEntity implements Serializable {
    @Id
    @Column(name = "username", nullable = false, unique = true, length = 20)
    private String username;
    @Id
    @Column(name = "role", nullable = false, length = 20)
    private String role;
    @Column(name = "created", nullable = false, columnDefinition = "DATETIME")
    private LocalDateTime created;

    @ManyToOne
    @JoinColumn(name = "username", referencedColumnName = "username", insertable = false, updatable = false)
    private UserEntity userEntity;

    public UserEntity getUserEntity() {
        return userEntity;
    }

    public void setUserEntity(UserEntity userEntity) {
        this.userEntity = userEntity;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public LocalDateTime getCreated() {
        return created;
    }

    public void setCreated(LocalDateTime created) {
        this.created = created;
    }

}
