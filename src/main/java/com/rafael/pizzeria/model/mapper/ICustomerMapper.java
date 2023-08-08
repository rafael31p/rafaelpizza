package com.rafael.pizzeria.model.mapper;

import com.rafael.pizzeria.model.dto.CustomerDTO;
import com.rafael.pizzeria.model.entity.Customer;
import org.mapstruct.Builder;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring", builder = @Builder(disableBuilder = true))
public interface ICustomerMapper {
    @Mapping(source = "idCustomer", target = "idCustomer")
    @Mapping(source = "name", target = "name")
    @Mapping(source = "address", target = "address")
    @Mapping(source = "email", target = "email")
    @Mapping(source = "phoneNumber", target = "phoneNumber")
    Customer toEntity(CustomerDTO customerDTO);
    CustomerDTO toDTO(Customer customer);
}
