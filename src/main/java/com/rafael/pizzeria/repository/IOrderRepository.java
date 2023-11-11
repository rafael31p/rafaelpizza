package com.rafael.pizzeria.repository;

import com.rafael.pizzeria.model.entity.Order;
import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.data.repository.ListCrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface IOrderRepository extends ListCrudRepository<Order, Integer> {
    List<Order> findAllByDateAfter(LocalDateTime fecha);
    List<Order> findAllByMethodIn(List<String> methods);
    @Procedure(value = "take_random_pizza_order", outputParameterName = "order_taken")
    boolean saveRandomOrder(@Param("id_customer") String idCustomer, @Param("method") String method);
}
