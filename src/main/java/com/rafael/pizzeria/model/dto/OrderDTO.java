package com.rafael.pizzeria.model.dto;

import com.rafael.pizzeria.model.entity.Customer;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;
@Data
@NoArgsConstructor
@AllArgsConstructor
public class OrderDTO {
    private Integer idOrder;
    private String idCustomer;
    private LocalDateTime date;
    private Double total;
    private String method;
    private String additionalNotes;
    private Customer customer;
    private List<OrderItemDTO> items;
}
