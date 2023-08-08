package com.rafael.pizzeria.service.impl;

import com.rafael.pizzeria.model.dto.PizzaDTO;
import com.rafael.pizzeria.model.mapper.IPizzaMapper;
import com.rafael.pizzeria.repository.IPizzaRepository;
import com.rafael.pizzeria.service.IPizzaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PizzaService implements IPizzaService {
    private final IPizzaRepository pizzaRepository;
    @Autowired
    private IPizzaMapper pizzaMapper;
    @Autowired
    public PizzaService(IPizzaRepository pizzaRepository) {
        this.pizzaRepository = pizzaRepository;
    }
    @Override
    public List<PizzaDTO> getAll(){
        return pizzaRepository.findAll().stream().map(pizzaMapper::toDTO).toList();
    }
    @Override
    public PizzaDTO getId(Integer id){
        return pizzaMapper.toDTO(pizzaRepository.findById(id).orElse(null));
    }
    @Override
    public PizzaDTO save(PizzaDTO pizzaDTO){
        return pizzaMapper.toDTO(pizzaRepository.save(pizzaMapper.toEntity(pizzaDTO)));
    }
    @Override
    public boolean exists(Integer id){
        return pizzaRepository.existsById(id);
    }
}
