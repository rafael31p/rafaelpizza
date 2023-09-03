package com.rafael.pizzeria.repository;

import com.rafael.pizzeria.model.entity.Pizza;
import org.springframework.data.repository.ListCrudRepository;

import java.util.List;

public interface IPizzaRepository extends ListCrudRepository<Pizza, Integer> {
    List<Pizza> findAllByAvailableTrueOrderByPrice();
    Pizza findFirstByAvailableTrueAndNameIgnoreCase(String name);

    List<Pizza> findAllByAvailableTrueAndDescriptionContainingIgnoreCase(String description);
    List<Pizza> findAllByAvailableTrueAndVegetarianTrue();
    List<Pizza> findAllByAvailableTrueAndDescriptionNotContainingIgnoreCase(String description);
    int countByVeganTrue();

    Pizza findAllByAvailableTrueOrderByIdPizzaDesc();
}
