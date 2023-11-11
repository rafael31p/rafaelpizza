package com.rafael.pizzeria.model.audit;

import lombok.Data;

import java.time.LocalDateTime;
@Data
public class AuditableDTO {
    private String createdUser;
    private String modifiedUser;
    private LocalDateTime createdDate;
    private LocalDateTime modifiedDate;
}
