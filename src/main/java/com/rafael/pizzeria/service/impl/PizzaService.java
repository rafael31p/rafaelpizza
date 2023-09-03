package com.rafael.pizzeria.service.impl;

import com.rafael.pizzeria.model.dto.PizzaDTO;
import com.rafael.pizzeria.model.mapper.IPizzaMapper;
import com.rafael.pizzeria.repository.IPizzaRepository;
import com.rafael.pizzeria.service.IPizzaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

@Service
public class PizzaService implements IPizzaService {
    private Logger logger = Logger.getLogger(PizzaService.class.getName());
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
    @Override
    public List<PizzaDTO> getAllPizzaAvailable(){
        return pizzaRepository.findAllByAvailableTrueOrderByPrice().stream().map(pizzaMapper::toDTO).toList();
    }
    @Override
    public PizzaDTO filterPizzaByName(String name){
        return pizzaMapper.toDTO(pizzaRepository.findFirstByAvailableTrueAndNameIgnoreCase(name));
    }
    @Override
    public List<PizzaDTO> filterPizzasByContainInDescription(String description){
        logger.log(Level.INFO, "Son Veganas: {0}", pizzaRepository.countByVeganTrue());
        return pizzaRepository.findAllByAvailableTrueAndDescriptionContainingIgnoreCase(description).stream().map(pizzaMapper::toDTO).toList();
    }
    @Override
    public List<PizzaDTO> filtarPizzaAvailableAndVegetaria(){
        return pizzaRepository.findAllByAvailableTrueAndVegetarianTrue().stream().map(pizzaMapper::toDTO).toList();
    }
    @Override
    public List<PizzaDTO> getAllPizzaNotCoteiningInTheDescription(String description){
        return pizzaRepository.findAllByAvailableTrueAndDescriptionNotContainingIgnoreCase(description).
                stream().
                map(pizzaMapper::toDTO).
                toList();
    }
}
