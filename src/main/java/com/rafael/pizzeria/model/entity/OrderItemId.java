package com.rafael.pizzeria.model.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Objects;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class OrderItemId implements Serializable {
    private Integer idOrder;
    private Integer idItem;
    @Override
    public boolean equals(Object o){
        if(this ==o) return true;
        if(!(o instanceof OrderItemId that)) return false;
        return Objects.equals(idOrder, that.idItem);
    }
    @Override
    public int hashCode(){
        return Objects.hash(idOrder, idItem);
    }
}
