package com.rafael.pizzeria.controller;

import com.rafael.pizzeria.service.IConsultaMetodoPagoService;
import com.rafael.pizzeria.utils.ListaObjetosDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/Api/consultaMetodoPago")
public class ConsultaMetodoPagoController {
    private final IConsultaMetodoPagoService metodoPagoService;

    public ConsultaMetodoPagoController(IConsultaMetodoPagoService metodoPagoService) {
        this.metodoPagoService = metodoPagoService;
    }

    @GetMapping("/generarListaDesplegableMetodoPago")
    public ResponseEntity<List<ListaObjetosDTO>> generarListaDesplegableMetodoPago(){
        return ResponseEntity.ok(metodoPagoService.consultarMetodosPago());
    }
}
