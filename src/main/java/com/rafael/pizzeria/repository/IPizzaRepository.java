package com.rafael.pizzeria.repository;

import com.rafael.pizzeria.model.entity.Pizza;
import org.springframework.data.repository.ListCrudRepository;

public interface IPizzaRepository extends ListCrudRepository<Pizza, Integer> {
}
