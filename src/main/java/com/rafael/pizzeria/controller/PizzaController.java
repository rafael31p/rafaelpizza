package com.rafael.pizzeria.controller;

import com.rafael.pizzeria.model.dto.PizzaDTO;
import com.rafael.pizzeria.model.entity.Pizza;
import com.rafael.pizzeria.service.IPizzaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/Api/pizza")
public class PizzaController {
    private final IPizzaService pizzaService;
    @Autowired
    public PizzaController(IPizzaService pizzaService) {
        this.pizzaService = pizzaService;
    }
    @GetMapping
    public ResponseEntity<List<PizzaDTO>> getAll(){
        return ResponseEntity.ok(this.pizzaService.getAll());
    }
    @GetMapping("/{id}")
    public ResponseEntity<PizzaDTO> findById(@PathVariable Integer id){
        return ResponseEntity.ok(this.pizzaService.getId(id));
    }
    @PostMapping("/save")
    public ResponseEntity<PizzaDTO> save(@RequestBody PizzaDTO pizzaDTO){
        if(pizzaDTO.getIdPizza()== null || this.pizzaService.exists(pizzaDTO.getIdPizza())){
            return ResponseEntity.ok(this.pizzaService.save(pizzaDTO));
        }
        return ResponseEntity.badRequest().build();
    }
    @PutMapping("/update")
    public ResponseEntity<PizzaDTO> update(@RequestBody PizzaDTO pizzaDTO){
        if(pizzaDTO.getIdPizza()!= null || this.pizzaService.exists(pizzaDTO.getIdPizza())){
            return ResponseEntity.ok(this.pizzaService.save(pizzaDTO));
        }
        return ResponseEntity.badRequest().build();
    }
}
