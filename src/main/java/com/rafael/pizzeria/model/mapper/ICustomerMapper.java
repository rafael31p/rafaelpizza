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
        customer.setCreatedUser(customerDTO.getCreatedUser());
        customer.setCreatedDate(customerDTO.getCreatedDate());
        customer.setModifiedUser(customerDTO.getModifiedUser());
        customer.setModifiedDate(customerDTO.getModifiedDate());
        return customer;
    }

    default CustomerDTO toDTO(Customer customer){
        CustomerDTO customerDTO = new CustomerDTO();
        customerDTO.setIdCustomer(customer.getIdCustomer());
        customerDTO.setName(customer.getName());
        customerDTO.setAddress(customer.getAddress());
        customerDTO.setEmail(customer.getEmail());
        customerDTO.setPhoneNumber(customer.getPhoneNumber());
        customerDTO.setCreatedUser(customer.getCreatedUser());
        customerDTO.setCreatedDate(customer.getCreatedDate());
        customerDTO.setModifiedUser(customer.getModifiedUser());
        customerDTO.setModifiedDate(customer.getModifiedDate());
        return customerDTO;
    }
}
