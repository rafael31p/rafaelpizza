package com.rafael.pizzeria.model.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@NoArgsConstructor
public class PizzaDTO implements Serializable {
    private Integer idPizza;
    private String name;
    private String description;
    private Double price;
    private Boolean vegetarian;
    private Boolean vegan;
    private Boolean available;
}
