package com.rafael.pizzeria.web.controller;

import com.rafael.pizzeria.model.dto.OrderDTO;
import com.rafael.pizzeria.model.dto.RamdonOrderDTO;
import com.rafael.pizzeria.service.IOrderService;
import org.aspectj.weaver.ast.Or;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("/Api/order")
public class OrderController {
    private final IOrderService orderService;
    @Autowired
    public OrderController(IOrderService orderService) {
        this.orderService = orderService;
    }

    @GetMapping
    public ResponseEntity<List<OrderDTO>> getAllOrder(){
        return ResponseEntity.ok(orderService.getAll());
    }

    @PutMapping("/getAllOrderAfterDate")
    public ResponseEntity<List<OrderDTO>> getAllOrderAfterDate(@RequestBody OrderDTO fecha){
        return ResponseEntity.ok(orderService.getAllOrderDateAfter(fecha.getDate()));
    }

    @PutMapping("/getAllByMethodForMethods")
    public ResponseEntity<List<OrderDTO>> getAllByMethodForMethods(@RequestBody List<String> methods){
        return ResponseEntity.ok(orderService.getAllMethodByMethods(methods));
    }
    @PutMapping("/saveRandomOrder")
    public ResponseEntity<Boolean> saveRandomOrder(@RequestBody RamdonOrderDTO ramdonOrderDTO){
        return ResponseEntity.ok(orderService.saveRandomOrder(ramdonOrderDTO));
    }
}
