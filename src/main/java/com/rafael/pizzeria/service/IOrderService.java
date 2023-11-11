package com.rafael.pizzeria.service;

import com.rafael.pizzeria.model.dto.OrderDTO;
import com.rafael.pizzeria.model.dto.RamdonOrderDTO;
import org.springframework.web.context.annotation.ApplicationScope;

import java.time.LocalDateTime;
import java.util.List;

@ApplicationScope
public interface   IOrderService {
    List<OrderDTO> getAll();

    List<OrderDTO> getAllOrderDateAfter(LocalDateTime fecha);

    List<OrderDTO> getAllMethodByMethods(List<String> methods);

    boolean saveRandomOrder(RamdonOrderDTO orderDTO);
}
