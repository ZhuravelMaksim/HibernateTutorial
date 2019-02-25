package com.it.dao.impl;

import com.it.dao.CarDAO;
import com.it.model.Car;
import com.it.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.query.Query;

import java.time.LocalDate;
import java.util.List;

public class CarDAOImpl extends GenericDAOImpl<Car, Long> implements CarDAO {
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

    /**
     * Find page of All Cars
     * HQL implementation
     *
     * @param firstResult - firstResult
     * @param maxResult   - maxResult
     * @return List<Car>
     */
    @Override
    public List<Car> findAll(Integer firstResult, Integer maxResult) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            String hql = "FROM Car";
            Query query = session.createQuery(hql);
            query.setFirstResult(firstResult);
            query.setMaxResults(maxResult);
            return query.list();
        }
    }

    /**
     * Find page of All Cars and fetching Details
     * HQL implementation
     *
     * @param firstResult - firstResult
     * @param maxResult   - maxResult
     * @return List<Car>
     */
    @Override
    public List<Car> findAllWithDetails(Integer firstResult, Integer maxResult) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            String hql = "FROM Car car JOIN FETCH car.details";
            Query query = session.createQuery(hql);
            query.setFirstResult(firstResult);
            query.setMaxResults(maxResult);
            return query.list();
        }
    }

    /**
     * Find Car by Model and Date
     * HQL implementation
     *
     * @param model - model
     * @param date  - date
     * @return Car
     */
    @Override
    public Car findByModelAndDate(String model, LocalDate date) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            String hql = "FROM Car car WHERE car.model = :model and car.dateOfManufacture = :date";
            Query query = session.createQuery(hql);
            query.setParameter("model", model);
            query.setParameter("date", date);
            return (Car) query.getSingleResult();
        }
    }
}
