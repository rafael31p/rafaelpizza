package com.rafael.pizzeria.model.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class PizzaDTO {
    private Integer idPizza;
    private String name;
    private String description;
    private Double price;
    private Boolean vegetarian;
    private Boolean vegan;
    private Boolean available;
}
