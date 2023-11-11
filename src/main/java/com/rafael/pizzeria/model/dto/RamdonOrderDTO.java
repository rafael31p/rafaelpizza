package com.rafael.pizzeria.model.dto;

import lombok.Data;

import java.io.Serializable;

@Data
public class RamdonOrderDTO implements Serializable {
    private String idCustomer;
    private String method;
}
