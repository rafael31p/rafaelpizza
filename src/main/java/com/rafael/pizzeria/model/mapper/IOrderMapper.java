package com.rafael.pizzeria.model.mapper;

import com.rafael.pizzeria.model.dto.CustomerDTO;
import com.rafael.pizzeria.model.dto.OrderDTO;
import com.rafael.pizzeria.model.entity.Customer;
import com.rafael.pizzeria.model.entity.Order;
import org.mapstruct.Mapper;
import org.springframework.beans.factory.annotation.Autowired;

@Mapper(componentModel = "spring", uses = {OrderItemMapper.class})
public interface IOrderMapper {
    default OrderDTO toDTO(Order order){
        ICustomerMapper iCustomerMapper = new ICustomerMapper() {
            @Override
            public CustomerDTO toDTO(Customer customer) {
                return ICustomerMapper.super.toDTO(customer);
            }
        };
        OrderDTO orderDTO = new OrderDTO();
        orderDTO.setIdOrder(order.getIdOrder());
        orderDTO.setIdCustomer(order.getIdCustomer());
        orderDTO.setDate(order.getDate());
        orderDTO.setMethod(order.getMethod());
        orderDTO.setTotal(order.getTotal());
        orderDTO.setAdditionalNotes(order.getAdditionalNotes());
        orderDTO.setIdCustomer(orderDTO.getIdCustomer());
        orderDTO.setCustomer(iCustomerMapper.toDTO(order.getCustomer()));
        return orderDTO;
    }
    default Order toEntity(OrderDTO orderDTO){
        Order order = new Order();
        ICustomerMapper iCustomerMapper = new ICustomerMapper() {
            @Override
            public Customer toEntity(CustomerDTO customerDTO) {
                return ICustomerMapper.super.toEntity(customerDTO);
            }
        };
        order.setIdOrder(orderDTO.getIdOrder());
        order.setIdCustomer(orderDTO.getIdCustomer());
        order.setDate(orderDTO.getDate());
        order.setMethod(orderDTO.getMethod());
        order.setTotal(orderDTO.getTotal());
        order.setAdditionalNotes(orderDTO.getAdditionalNotes());
        order.setIdCustomer(orderDTO.getIdCustomer());
        order.setCustomer(iCustomerMapper.toEntity(orderDTO.getCustomer()));
        return order;
    }
}
