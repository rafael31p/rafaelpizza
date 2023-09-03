package com.rafael.pizzeria.controller;

import com.rafael.pizzeria.model.dto.PizzaDTO;
import com.rafael.pizzeria.service.IPizzaPagSortService;
import com.rafael.pizzeria.service.IPizzaService;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/Api/pizza")
public class PizzaController {
    private final IPizzaService pizzaService;
    private final IPizzaPagSortService pizzaPagSortService;
    public PizzaController(IPizzaService pizzaService, IPizzaPagSortService pizzaPagSortService) {
        this.pizzaService = pizzaService;
        this.pizzaPagSortService = pizzaPagSortService;
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

    @GetMapping("/getAllPizzaAvailable")
    public ResponseEntity<List<PizzaDTO>> getAllPizzaAvailable(){
        return ResponseEntity.ok(this.pizzaService.getAllPizzaAvailable());
    }
    @GetMapping("/filterPizzaByName/{name}")
    public ResponseEntity<PizzaDTO> filterPizzaByName(@PathVariable String name){
        return ResponseEntity.ok(this.pizzaService.filterPizzaByName(name));
    }

    @GetMapping("/filterPizzasByContainInDescription/{description}")
    public ResponseEntity<List<PizzaDTO>> filterPizzasByContainInDescription(@PathVariable String description){
        return ResponseEntity.ok(this.pizzaService.filterPizzasByContainInDescription(description));
    }

    @GetMapping("/getAllPizzaVegetarian")
    public ResponseEntity<List<PizzaDTO>> getAllPizzaAvailableAndPizzaVegetarian(){
        return ResponseEntity.ok(this.pizzaService.filtarPizzaAvailableAndVegetaria());
    }

    @GetMapping("/getAllPizzaNotConteiningInTheDescription/{description}")
    public ResponseEntity<List<PizzaDTO>> getAllPizzaNotConteiningInTheDescription(@PathVariable String description){
        return ResponseEntity.ok(this.pizzaService.getAllPizzaNotCoteiningInTheDescription(description));
    }

    @GetMapping("/getAllPizzaAvailablePage")
    public ResponseEntity<Page<PizzaDTO>> getAllPizzaAvailable(@RequestParam(defaultValue = "0") int page,
                                                               @RequestParam(defaultValue = "15") int element){
        return ResponseEntity.ok(this.pizzaPagSortService.getAllAvailable(page, element));
    }
    @GetMapping("/getAllPizzaAvailableOrderByPage")
    public ResponseEntity<Page<PizzaDTO>> getAllPizzaAvailableOrderBy(@RequestParam(defaultValue = "0") int page,
                                                               @RequestParam(defaultValue = "15") int element, @RequestParam(defaultValue = "price") String orderBy){
        return ResponseEntity.ok(this.pizzaPagSortService.getAllAvailableOrderByPrice(page, element, orderBy));
    }
}
