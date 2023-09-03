package com.rafael.pizzeria.model.mapper;

import com.rafael.pizzeria.model.dto.CustomerDTO;
import com.rafael.pizzeria.model.entity.Customer;
import org.mapstruct.Builder;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring", builder = @Builder(disableBuilder = true))
public interface ICustomerMapper {
    default Customer toEntity(CustomerDTO customerDTO) {
        Customer customer = new Customer();
        customer.setIdCustomer(customerDTO.getIdCustomer());
        customer.setName(customerDTO.getName());
        customer.setAddress(customerDTO.getAddress());
        customer.setEmail(customerDTO.getEmail());
        customer.setPhoneNumber(customerDTO.getPhoneNumber());
        return customer;
    }

    default CustomerDTO toDTO(Customer customer){
        CustomerDTO customerDTO = new CustomerDTO();
        customerDTO.setIdCustomer(customer.getIdCustomer());
        customerDTO.setName(customer.getName());
        customerDTO.setAddress(customer.getAddress());
        customerDTO.setEmail(customer.getEmail());
        customerDTO.setPhoneNumber(customer.getPhoneNumber());
        return customerDTO;
    }
}
