package com.it.app;

import com.it.dao.DetailDAO;
import com.it.dao.CarDAO;
import com.it.dao.impl.DetailDAOImpl;
import com.it.dao.impl.CarDAOImpl;
import com.it.model.Car;
import com.it.model.CarId;
import com.it.model.Detail;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

public class Main {
    private static final CarDAO carDAO = CarDAOImpl.getInstance();
    private static final DetailDAO detailDAO = DetailDAOImpl.getInstance();

    public static void main(String[] arguments) {
        CarId carId = new CarId("Mitsubishi", "Lancer");
        createCar(carId);
        Car persistCar = carDAO.getOne(carId);
        createDetail(persistCar);
    }

    private static void createDetail(Car persistCar) {
        Detail transientDetail = new Detail();
        transientDetail.setName("Engine");
        transientDetail.setCode("1123X-11");
        transientDetail.setCar(persistCar);
        detailDAO.save(transientDetail);
    }

    private static void createCar(CarId id) {
        Car transientCar = new Car();
        transientCar.setId(id);
        transientCar.setDateOfManufacture(LocalDate.of(2005, 1, 1));
        carDAO.save(transientCar);
    }
}
