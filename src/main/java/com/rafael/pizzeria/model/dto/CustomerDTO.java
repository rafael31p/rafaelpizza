package com.rafael.pizzeria.model.dto;

import com.rafael.pizzeria.model.audit.AuditableDTO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CustomerDTO extends AuditableDTO implements Serializable {
    private String idCustomer;
    private String name;
    private String address;
    private String email;
    private String phoneNumber;
}
