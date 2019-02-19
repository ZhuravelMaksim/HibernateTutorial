package com.it.app;

import com.it.dao.DetailDAO;
import com.it.dao.CarDAO;
import com.it.dao.impl.DetailDAOImpl;
import com.it.dao.impl.CarDAOImpl;
import com.it.model.Car;
import com.it.model.Detail;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

public class Main {
    private static final CarDAO carDAO = CarDAOImpl.getInstance();
    private static final DetailDAO detailDAO = DetailDAOImpl.getInstance();

    public static void main(String[] arguments) {
        createCar();
        Car persistCar = carDAO.getOne(1L);
        createDetail(persistCar);

    }

    private static void createDetail(Car persistCar) {
        Detail transientDetail = new Detail();
        transientDetail.setName("Engine");
        transientDetail.setCode("1123X-11");
        transientDetail.setCar(persistCar);
        detailDAO.save(transientDetail);
    }

    private static void createCar() {
        Car transientCar = new Car();
        transientCar.setModel("Mitsubishi Lancer");
        transientCar.setDateOfManufacture(LocalDate.of(2005, 1, 1));
        carDAO.save(transientCar);
    }
}
