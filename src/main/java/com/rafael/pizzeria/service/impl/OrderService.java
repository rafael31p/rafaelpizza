package com.rafael.pizzeria.service.impl;

import com.rafael.pizzeria.model.dto.OrderDTO;
import com.rafael.pizzeria.model.dto.RamdonOrderDTO;
import com.rafael.pizzeria.model.mapper.IOrderMapper;
import com.rafael.pizzeria.repository.IOrderRepository;
import com.rafael.pizzeria.service.IOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

@Service
public class OrderService implements IOrderService {
    @Autowired
    private IOrderRepository orderRepository;
    private Logger logger = Logger.getLogger(OrderService.class.getName());
    @Autowired
    private IOrderMapper orderMapper;
    @Override
    public List<OrderDTO> getAll(){
        List<OrderDTO> orders = orderRepository.findAll().stream().map(orderMapper::toDTO).toList();
        orders.forEach(o ->logger.log(Level.INFO, "nombre {0}", o.getCustomer().getName()));
        return orders;
    }
    @Override
    public List<OrderDTO> getAllOrderDateAfter(LocalDateTime fecha){
        return orderRepository.findAllByDateAfter(fecha).stream().map(orderMapper::toDTO).toList();
    }
    @Override
    public List<OrderDTO> getAllMethodByMethods(List<String> methods){
        return orderRepository.findAllByMethodIn(methods).stream().map(orderMapper::toDTO).toList();
    }
    @Override
    public boolean saveRandomOrder(RamdonOrderDTO orderDTO){
        return orderRepository.saveRandomOrder(orderDTO.getIdCustomer(), orderDTO.getMethod());
    }
    //necesito que generes un servicio que consulte las ordenes por fecha
    //necesito que generes un servicio que consulte las ordenes por metodo de pago

}
