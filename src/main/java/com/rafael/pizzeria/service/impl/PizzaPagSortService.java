package com.rafael.pizzeria.service.impl;

import com.rafael.pizzeria.model.dto.PizzaDTO;
import com.rafael.pizzeria.model.entity.Pizza;
import com.rafael.pizzeria.model.mapper.IPizzaMapper;
import com.rafael.pizzeria.repository.IPizzaPagSortRepository;
import com.rafael.pizzeria.service.IPizzaPagSortService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.*;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PizzaPagSortService implements IPizzaPagSortService {
    private final IPizzaPagSortRepository pizzaPagSortRepository;
    private final IPizzaMapper pizzaMapper;
    @Autowired
    public PizzaPagSortService(IPizzaPagSortRepository pizzaPagSortRepository, IPizzaMapper pizzaMapper) {
        this.pizzaPagSortRepository = pizzaPagSortRepository;
        this.pizzaMapper = pizzaMapper;
    }
    @Override
    public Page<PizzaDTO> getAllAvailable(int page, int element){
        Pageable pageable = PageRequest.of(page, element);
        return convertPizzaToPizaDTO(pizzaPagSortRepository.findAllByAvailableTrue(pageable));
    }
    @Override
    public Page<PizzaDTO> getAllAvailableOrderByPrice(int page, int element, String sortBy){
        Pageable pageable = PageRequest.of(page, element, Sort.by(sortBy));
        return convertPizzaToPizaDTO(pizzaPagSortRepository.findAllByAvailableTrue(pageable));
    }
    private Page<PizzaDTO> convertPizzaToPizaDTO(Page<Pizza> pizzaPage){
        List<PizzaDTO> pizzaDTOS = pizzaPage.stream().map(pizzaMapper::toDTO).toList();
        Page<PizzaDTO> pizzaDTOPage = new PageImpl<>(pizzaDTOS);
        return pizzaDTOPage;
    }
}
