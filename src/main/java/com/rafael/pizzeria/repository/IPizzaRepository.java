package com.rafael.pizzeria.repository;

import com.rafael.pizzeria.model.entity.Pizza;
import org.springframework.data.repository.ListCrudRepository;

import java.util.List;

public interface IPizzaRepository extends ListCrudRepository<Pizza, Integer> {
    List<Pizza> findAllByAvailableTrueOrderByPrice();
    Pizza findFirstByAvailableTrueAndNameIgnoreCase(String name);
    List<Pizza> findAllByAvailableTrueAndVeganTrue();
    List<Pizza> findAllByAvailableTrueAndVeganFalse();
    List<Pizza> findAllByAvailableTrueAndVegetarianFalse();
    List<Pizza> findAllByAvailableTrueAndVegetarianTrueAndVeganTrue();
    List<Pizza> findAllByAvailableTrueAndVegetarianTrueAndVeganFalse();
    List<Pizza> findAllByAvailableTrueAndVegetarianFalseAndVeganFalse();
    List<Pizza> findAllByAvailableTrueAndVegetarianFalseAndVeganTrue();
    List<Pizza> findAllByAvailableTrueAndNameContainingIgnoreCase(String name);

    List<Pizza> findAllByAvailableTrueAndDescriptionContainingIgnoreCase(String description);
    List<Pizza> findAllByAvailableTrueAndVegetarianTrue();
    List<Pizza> findAllByAvailableTrueAndDescriptionNotContainingIgnoreCase(String description);
    int countByVeganTrue();

    Pizza findAllByAvailableTrueOrderByIdPizzaDesc();
    Pizza findAllByAvailableTrueOrderByIdPizzaAsc();

    List<Pizza> findAllByAvailableTrueAndPriceBetween(double min, double max);
    List<Pizza> findAllByAvailableTrueAndPriceLessThanEqual(double max);
    List<Pizza> findAllByAvailableTrueAndPriceGreaterThanEqual(double min);
    List<Pizza> findAllByAvailableTrueAndPriceGreaterThanEqualAndPriceLessThanEqual(double min, double max);
    List<Pizza> findAllByAvailableTrueAndVegetarianTrueAndPriceBetween(double min, double max);
    List<Pizza> findAllByAvailableTrueAndVegetarianTrueAndPriceLessThanEqual(double max);
    List<Pizza> findAllByAvailableTrueAndVegetarianTrueAndPriceGreaterThanEqual(double min);
    List<Pizza> findAllByAvailableTrueAndVegetarianTrueAndPriceGreaterThanEqualAndPriceLessThanEqual(double min, double max);
    List<Pizza> findAllByAvailableTrueAndVegetarianFalseAndPriceBetween(double min, double max);
    List<Pizza> findAllByAvailableTrueAndVegetarianFalseAndPriceLessThanEqual(double max);
    List<Pizza> findAllByAvailableTrueAndVegetarianFalseAndPriceGreaterThanEqual(double min);
    List<Pizza> findAllByAvailableTrueAndVegetarianFalseAndPriceGreaterThanEqualAndPriceLessThanEqual(double min, double max);
    List<Pizza> findAllByAvailableTrueAndVeganTrueAndPriceBetween(double min, double max);
    List<Pizza> findAllByAvailableTrueAndVeganTrueAndPriceLessThanEqual(double max);
    List<Pizza> findAllByAvailableTrueAndVeganTrueAndPriceGreaterThanEqual(double min);
    List<Pizza> findAllByAvailableTrueAndVeganTrueAndPriceGreaterThanEqualAndPriceLessThanEqual(double min, double max);
    List<Pizza> findAllByAvailableTrueAndVeganFalseAndPriceBetween(double min, double max);
    List<Pizza> findAllByAvailableTrueAndVeganFalseAndPriceLessThanEqual(double max);
    List<Pizza> findAllByAvailableTrueAndVeganFalseAndPriceGreaterThanEqual(double min);
    List<Pizza> findAllByAvailableTrueAndVeganFalseAndPriceGreaterThanEqualAndPriceLessThanEqual(double min, double max);
}
