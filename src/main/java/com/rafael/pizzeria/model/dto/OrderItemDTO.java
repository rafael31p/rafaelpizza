package com.rafael.pizzeria.model.dto;

import com.rafael.pizzeria.model.entity.Order;
import com.rafael.pizzeria.model.entity.Pizza;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class OrderItemDTO implements Serializable {
    private Integer idOrder;
    private Integer idItem;
    private Integer idPizza;
    private Double quantity;
    private Double price;
    private PizzaDTO pizza;
    private OrderDTO order;
}
