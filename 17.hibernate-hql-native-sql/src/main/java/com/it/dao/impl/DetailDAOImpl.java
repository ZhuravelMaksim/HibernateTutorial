package com.it.dao.impl;

import com.it.dao.DetailDAO;
import com.it.model.Car;
import com.it.model.Detail;
import com.it.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.query.Query;

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
            String hql = "SELECT detail.* FROM Detail detail";
            Query query = session.createNativeQuery(hql, Detail.class);
            query.setFirstResult(firstResult);
            query.setMaxResults(maxResult);
            return query.list();
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
            String hql = "SELECT detail.* FROM Detail detail WHERE detail.car_id=?1";
            Query query = session.createNativeQuery(hql, Detail.class);
            query.setParameter(1, carId);
            query.setFirstResult(firstResult);
            query.setMaxResults(maxResult);
            return query.list();
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
            String hql = "SELECT detail.* FROM Detail detail WHERE detail.name=?1 AND detail.code=?2";
            Query query = session.createNativeQuery(hql, Detail.class);
            query.setParameter(1, name);
            query.setParameter(2, code);
            return (Detail) query.getSingleResult();
        }
    }
}
