package com.it.dao.impl;

import com.it.dao.CarDAO;
import com.it.model.Car;
import com.it.model.CarId;

public class CarDAOImpl extends GenericDAOImpl<Car, CarId> implements CarDAO {
    private static CarDAOImpl instance;

    private CarDAOImpl() {
        super(Car.class);
    }

    synchronized public static CarDAOImpl getInstance() {
        if (instance == null) {
            instance = new CarDAOImpl();
        }
        return instance;
    }
}
