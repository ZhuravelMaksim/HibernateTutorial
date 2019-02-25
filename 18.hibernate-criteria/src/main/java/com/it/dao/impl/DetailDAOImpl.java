package com.it.dao.impl;

import com.it.dao.DetailDAO;
import com.it.model.Car;
import com.it.model.Car_;
import com.it.model.Detail;
import com.it.model.Detail_;
import com.it.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.query.Query;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.List;

public class DetailDAOImpl extends GenericDAOImpl<Detail, Long> implements DetailDAO {
    private static DetailDAOImpl instance;

    private DetailDAOImpl() {
        super(Detail.class);
    }

    synchronized public static DetailDAOImpl getInstance() {
        if (instance == null) {
            instance = new DetailDAOImpl();
        }
        return instance;
    }

    /**
     * Find page of All Details
     * NativeSQl implementation
     *
     * @param firstResult - firstResult
     * @param maxResult   - maxResult
     * @return List<Detail>
     */
    @Override
    public List<Detail> findAll(Integer firstResult, Integer maxResult) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            CriteriaBuilder criteriaBuilder = session.getCriteriaBuilder();
            CriteriaQuery<Detail> criteriaQuery = criteriaBuilder.createQuery(Detail.class);
            Root<Detail> root = criteriaQuery.from(Detail.class);
            criteriaQuery.select(root);
            Query<Detail> detailQuery = session.createQuery(criteriaQuery);
            return detailQuery.getResultList();
        }
    }

    /**
     * Find page of All Details by CarId
     * NativeSQl implementation
     *
     * @param firstResult - firstResult
     * @param maxResult   - maxResult
     * @param carId       - carId
     * @return List<Detail>
     */
    @Override
    public List<Detail> findAllByCarId(Integer firstResult, Integer maxResult, Long carId) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            CriteriaBuilder criteriaBuilder = session.getCriteriaBuilder();
            CriteriaQuery<Detail> criteriaQuery = criteriaBuilder.createQuery(Detail.class);
            Root<Detail> root = criteriaQuery.from(Detail.class);
            Predicate modelPredicate = criteriaBuilder.equal(root.get(Detail_.car).get(Car_.id), carId);
            Predicate predicate = criteriaBuilder.and(modelPredicate);
            criteriaQuery.select(root).where(predicate);
            Query<Detail> detailQuery = session.createQuery(criteriaQuery);
            return detailQuery.getResultList();
        }
    }

    /**
     * Find Detail by Name And Code
     * NativeSQl implementation
     *
     * @param name - name
     * @param code - code
     * @return Detail
     */
    @Override
    public Detail findByNameAndCode(String name, String code) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            CriteriaBuilder criteriaBuilder = session.getCriteriaBuilder();
            CriteriaQuery<Detail> criteriaQuery = criteriaBuilder.createQuery(Detail.class);
            Root<Detail> root = criteriaQuery.from(Detail.class);
            Predicate modelPredicate = criteriaBuilder.equal(root.get(Detail_.name), name);
            Predicate datePredicate = criteriaBuilder.equal(root.get(Detail_.code), code);
            Predicate predicate = criteriaBuilder.and(modelPredicate, datePredicate);
            criteriaQuery.select(root).where(predicate);
            Query<Detail> detailQuery = session.createQuery(criteriaQuery);
            return detailQuery.getSingleResult();
        }
    }
}
