package com.rafael.pizzeria.utils;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ListaObjetosDTO implements Serializable {
    private String valor;
    private String etiqueta;
    private Boolean exitoso;

}
