package com.rafael.pizzeria.service;

import com.rafael.pizzeria.utils.ListaObjetosDTO;
import org.springframework.web.context.annotation.ApplicationScope;

import java.util.List;

@ApplicationScope
public interface IConsultaMetodoPagoService {
    List<ListaObjetosDTO> consultarMetodosPago();
}
