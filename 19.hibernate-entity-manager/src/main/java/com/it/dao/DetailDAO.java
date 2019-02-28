package com.it.dao;

import com.it.model.Detail;

import java.util.List;

public interface DetailDAO extends GenericDAO<Detail, Long> {
    List<Detail> findAll(Integer firstResult, Integer maxResult);

    List<Detail> findAllByCarId(Integer firstResult, Integer maxResult, Long carId);

    Detail findByNameAndCode(String name, String code);
}
