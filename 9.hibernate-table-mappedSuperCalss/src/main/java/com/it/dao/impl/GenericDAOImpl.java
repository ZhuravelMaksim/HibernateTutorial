package com.it.dao.impl;

import com.it.dao.GenericDAO;
import com.it.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.io.Serializable;

public abstract class GenericDAOImpl<T, U> implements GenericDAO<T, U> {
    private final Class<T> type;

    GenericDAOImpl(Class<T> type) {
        this.type = type;
    }

    /**
     * Gets persistent entity by id
     *
     * @param id - entity ID
     */
    @Override
    public T getOne(U id) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            return session.get(type, (Serializable) id);
        }
    }

    /**
     * Deletes persistent entity by id
     *
     * @param id - entity ID
     */
    @Override
    public void delete(U id) {
        Transaction transaction = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            T entity = session.get(type, (Serializable) id);
            if (entity != null) {
                session.delete(entity);
            }
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
        }
    }

    /**
     * Saves an transient entity
     *
     * @param entity - transient entity
     */
    @Override
    public void save(T entity) {
        Transaction transaction = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            session.save(entity);
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
        }
    }

    /**
     * Updates a persistent\detached entity
     *
     * @param entity - persistent\detached entity
     */
    @Override
    public void update(T entity) {
        Transaction transaction = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            session.update(entity);
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
        }
    }
}
