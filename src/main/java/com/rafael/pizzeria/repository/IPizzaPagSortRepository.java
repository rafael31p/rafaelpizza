package com.rafael.pizzeria.repository;

import com.rafael.pizzeria.model.entity.Pizza;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.ListPagingAndSortingRepository;

public interface IPizzaPagSortRepository extends ListPagingAndSortingRepository<Pizza, Integer> {
    Page<Pizza> findAllByAvailableTrue(Pageable pageable);
}
