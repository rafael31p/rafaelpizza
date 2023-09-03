package com.rafael.pizzeria.service;

import com.rafael.pizzeria.model.dto.PizzaDTO;
import org.springframework.data.domain.Page;
import org.springframework.web.context.annotation.ApplicationScope;

@ApplicationScope
public interface IPizzaPagSortService {
    Page<PizzaDTO> getAllAvailable(int page, int element);

    Page<PizzaDTO> getAllAvailableOrderByPrice(int page, int element, String sortBy);
}
