package com.it.app;

import com.it.dao.DetailDAO;
import com.it.dao.CarDAO;
import com.it.dao.impl.DetailDAOImpl;
import com.it.dao.impl.CarDAOImpl;
import com.it.model.Car;
import com.it.model.Detail;

import java.time.LocalDate;
import java.util.List;

public class Main {
    private static final CarDAO carDAO = CarDAOImpl.getInstance();
    private static final DetailDAO detailDAO = DetailDAOImpl.getInstance();

    public static void main(String[] arguments) {
        createCar();
        Car persistCar = carDAO.getOne(1L);
        createDetail(persistCar);
        hqlExample();
        nativeSQLExample();
    }

    private static void nativeSQLExample() {
        List<Detail> detailList = detailDAO.findAll(0, 10);
        System.out.println(detailList.get(0).getName());

        List<Detail> carDetailList = detailDAO.findAllByCarId(0, 10, 1L);
        System.out.println(carDetailList.get(0).getCar().getModel());

        Detail detail = detailDAO.findByNameAndCode("Engine", "1123X-11");
        System.out.println(detail.getName());
    }

    private static void hqlExample() {
        List<Car> carList = carDAO.findAll(0, 10);
        //if we try to get details here we will get the HibernateLazyException

        List<Car> carListWithDetails = carDAO.findAllWithDetails(0, 10);
        //but here we have JOIN FETCH
        System.out.println(carListWithDetails.get(0).getDetails().size());

        Car car = carDAO.findByModelAndDate("Mitsubishi Lancer", LocalDate.of(2005, 1, 1));
        System.out.println(car.getModel());
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
