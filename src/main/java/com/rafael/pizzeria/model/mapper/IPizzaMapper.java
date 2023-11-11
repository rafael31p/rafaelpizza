package com.rafael.pizzeria.model.mapper;

import com.rafael.pizzeria.model.dto.PizzaDTO;
import com.rafael.pizzeria.model.entity.Pizza;
import org.antlr.v4.runtime.misc.NotNull;
import org.mapstruct.Builder;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring", builder = @Builder(disableBuilder = true))
public interface IPizzaMapper {
    @Mapping(target = "idPizza", source = "idPizza")
    @Mapping(target = "name", source = "name")
    @Mapping(target = "description", source = "description")
    @Mapping(target = "price", source = "price")
    @Mapping(target = "vegetarian", source = "vegetarian")
    @Mapping(target = "vegan", source = "vegan")
    @Mapping(target = "available", source = "available")
    default Pizza toEntity(PizzaDTO pizzaDTO){
        Pizza pizza = new Pizza();
        pizza.setIdPizza(pizzaDTO.getIdPizza());
        pizza.setName(pizzaDTO.getName());
        pizza.setDescription(pizzaDTO.getDescription());
        pizza.setPrice(pizzaDTO.getPrice());
        pizza.setVegetarian(pizzaDTO.getVegetarian());
        pizza.setVegan(pizzaDTO.getVegan());
        pizza.setAvailable(pizzaDTO.getAvailable());
        pizza.setCreatedUser(pizzaDTO.getCreatedUser());
        pizza.setModifiedUser(pizzaDTO.getModifiedUser());
        return pizza;
    }
    default PizzaDTO toDTO(Pizza pizza){
        PizzaDTO pizzaDTO = new PizzaDTO();
        pizzaDTO.setIdPizza(pizza.getIdPizza());
        pizzaDTO.setName(pizza.getName());
        pizzaDTO.setDescription(pizza.getDescription());
        pizzaDTO.setPrice(pizza.getPrice());
        pizzaDTO.setVegetarian(pizza.getVegetarian());
        pizzaDTO.setVegan(pizza.getVegan());
        pizzaDTO.setAvailable(pizza.getAvailable());
        pizzaDTO.setCreatedUser(pizza.getCreatedUser());
        pizzaDTO.setModifiedUser(pizza.getModifiedUser());
        pizzaDTO.setCreatedDate(pizza.getCreatedDate());
        pizzaDTO.setModifiedDate(pizza.getModifiedDate());
        return pizzaDTO;
    }

}
