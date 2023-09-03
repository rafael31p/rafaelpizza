package com.rafael.pizzeria.model.mapper;

import com.rafael.pizzeria.model.dto.OrderDTO;
import com.rafael.pizzeria.model.dto.OrderItemDTO;
import com.rafael.pizzeria.model.dto.PizzaDTO;
import com.rafael.pizzeria.model.entity.Order;
import com.rafael.pizzeria.model.entity.OrderItem;
import com.rafael.pizzeria.model.entity.Pizza;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring", uses = {IPizzaMapper.class, IOrderMapper.class})
public interface OrderItemMapper {
    default OrderItemDTO toDTO(OrderItem orderItem){
        IOrderMapper orderMapper = new IOrderMapper() {
            @Override
            public OrderDTO toDTO(Order order) {
                return IOrderMapper.super.toDTO(order);
            }
        };
        IPizzaMapper pizzaMapper = new IPizzaMapper() {
            @Override
            public PizzaDTO toDTO(Pizza pizza) {
                return IPizzaMapper.super.toDTO(pizza);
            }
        };
        OrderItemDTO orderItemDTO = new OrderItemDTO();
        orderItemDTO.setIdItem(orderItem.getIdItem());
        orderItemDTO.setIdOrder(orderItemDTO.getIdOrder());
        orderItemDTO.setPrice(orderItem.getPrice());
        orderItemDTO.setOrder(orderMapper.toDTO(orderItem.getOrder()));
        orderItemDTO.setQuantity(orderItemDTO.getQuantity());
        orderItemDTO.setPizza(pizzaMapper.toDTO(orderItem.getPizza()));
        return orderItemDTO;
    }
    default OrderItem toEntity(OrderItemDTO orderItemDTO){
        IOrderMapper orderMapper = new IOrderMapper() {
            @Override
            public Order toEntity(OrderDTO orderDTO) {
                return IOrderMapper.super.toEntity(orderDTO);
            }
        };
        IPizzaMapper pizzaMapper = new IPizzaMapper() {
            @Override
            public Pizza toEntity(PizzaDTO pizzaDTO) {
                return IPizzaMapper.super.toEntity(pizzaDTO);
            }
        };
        OrderItem orderItem = new OrderItem();
        orderItem.setIdItem(orderItemDTO.getIdItem());
        orderItem.setIdOrder(orderItemDTO.getIdOrder());
        orderItem.setPrice(orderItemDTO.getPrice());
        orderItem.setOrder(orderMapper.toEntity(orderItemDTO.getOrder()));
        orderItem.setQuantity(orderItemDTO.getQuantity());
        orderItem.setPizza(pizzaMapper.toEntity(orderItemDTO.getPizza()));
        return orderItem;
    }
}
