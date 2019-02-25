package com.it.dao.impl;

import com.it.dao.CarDAO;
import com.it.model.Car;
import com.it.model.Car_;
import com.it.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.query.Query;

import javax.persistence.criteria.*;
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
     * Criteria implementation
     *
     * @param firstResult - firstResult
     * @param maxResult   - maxResult
     * @return List<Car>
     */
    @Override
    public List<Car> findAll(Integer firstResult, Integer maxResult) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            CriteriaQuery<Car> criteriaQuery = session.getCriteriaBuilder().createQuery(Car.class);
            Root<Car> root = criteriaQuery.from(Car.class);
            criteriaQuery.select(root);
            Query<Car> carQuery = session.createQuery(criteriaQuery);
            carQuery.setFirstResult(firstResult);
            carQuery.setMaxResults(maxResult);
            return carQuery.getResultList();
        }
    }

    /**
     * Find page of All Cars and fetching Details
     * Criteria implementation
     *
     * @param firstResult - firstResult
     * @param maxResult   - maxResult
     * @return List<Car>
     */
    @Override
    public List<Car> findAllWithDetails(Integer firstResult, Integer maxResult) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            CriteriaQuery<Car> criteriaQuery = session.getCriteriaBuilder().createQuery(Car.class);
            Root<Car> root = criteriaQuery.from(Car.class);
            root.fetch(Car_.details, JoinType.INNER);
            criteriaQuery.select(root);
            Query<Car> carQuery = session.createQuery(criteriaQuery);
            carQuery.setFirstResult(firstResult);
            carQuery.setMaxResults(maxResult);
            return carQuery.getResultList();
        }
    }

    /**
     * Find Car by Model and Date
     * Criteria implementation
     *
     * @param model - model
     * @param date  - date
     * @return Car
     */
    @Override
    public Car findByModelAndDate(String model, LocalDate date) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            CriteriaBuilder criteriaBuilder = session.getCriteriaBuilder();
            CriteriaQuery<Car> criteriaQuery = criteriaBuilder.createQuery(Car.class);
            Root<Car> root = criteriaQuery.from(Car.class);
            Predicate modelPredicate = criteriaBuilder.equal(root.get(Car_.model), model);
            Predicate datePredicate = criteriaBuilder.equal(root.get(Car_.dateOfManufacture), date);
            Predicate predicate = criteriaBuilder.and(modelPredicate, datePredicate);
            criteriaQuery.select(root).where(predicate);
            Query<Car> carQuery = session.createQuery(criteriaQuery);
            return carQuery.getSingleResult();
        }
    }
}
