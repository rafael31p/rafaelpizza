package com.rafael.pizzeria.model.mapper;

import com.rafael.pizzeria.model.dto.PizzaDTO;
import com.rafael.pizzeria.model.entity.Pizza;
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
    Pizza toEntity(PizzaDTO pizzaDTO);

    PizzaDTO toDTO(Pizza pizza);

}
