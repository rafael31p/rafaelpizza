package com.rafael.pizzeria.model.dto;

import com.rafael.pizzeria.model.audit.AuditableDTO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.List;
@Data
@NoArgsConstructor
@AllArgsConstructor
public class OrderDTO extends AuditableDTO implements Serializable {
    private Integer idOrder;
    private String idCustomer;
    private LocalDateTime date;
    private Double total;
    private String method;
    private String additionalNotes;
    private CustomerDTO customer;
    private List<OrderItemDTO> items;
}
