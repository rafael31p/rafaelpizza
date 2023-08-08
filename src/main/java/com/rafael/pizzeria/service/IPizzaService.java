package com.rafael.pizzeria.service;

import com.rafael.pizzeria.model.dto.PizzaDTO;
import com.rafael.pizzeria.model.entity.Pizza;
import org.springframework.web.context.annotation.ApplicationScope;

import java.util.List;

@ApplicationScope
public interface IPizzaService {
    List<PizzaDTO> getAll();

    PizzaDTO getId(Integer id);

    PizzaDTO save(PizzaDTO pizzaDTO);

    boolean exists(Integer id);
}
