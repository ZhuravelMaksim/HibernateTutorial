package com.it.dao;

import com.it.model.Car;

import java.time.LocalDate;
import java.util.List;

public interface CarDAO extends GenericDAO<Car, Long> {
    List<Car> findAll(Integer firstResult, Integer maxResult);

    List<Car> findAllWithDetails(Integer firstResult, Integer maxResult);

    Car findByModelAndDate(String model, LocalDate date);
}
