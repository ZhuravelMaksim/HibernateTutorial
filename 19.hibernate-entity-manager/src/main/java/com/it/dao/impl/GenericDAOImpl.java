package com.it.dao.impl;

import com.it.dao.GenericDAO;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public abstract class GenericDAOImpl<T, U> implements GenericDAO<T, U> {
    private EntityManagerFactory entityManagerFactory;

    public synchronized EntityManager getEntityManager() {
        if (entityManagerFactory == null) {
            entityManagerFactory = Persistence.createEntityManagerFactory("com.it");
        }
        return entityManagerFactory.createEntityManager();
    }

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
        EntityManager entityManager = getEntityManager();
        return entityManager.find(type, id);
    }

    /**
     * Deletes persistent entity by id
     *
     * @param id - entity ID
     */
    @Override
    public void delete(U id) {
        EntityManager entityManager = getEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();
        T entity = entityManager.find(type, id);
        if (entity != null) {
            transaction.begin();
            entityManager.remove(entity);
            transaction.commit();
        }
        entityManager.close();
    }

    /**
     * Saves an transient entity
     *
     * @param entity - transient entity
     */
    @Override
    public void save(T entity) {
        EntityManager entityManager = getEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();
        entityManager.persist(entity);
        transaction.commit();
        entityManager.close();
    }

    /**
     * Updates a persistent\detached entity
     *
     * @param entity - persistent\detached entity
     * @return T
     */
    @Override
    public T update(T entity) {
        EntityManager entityManager = getEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();
        entity = entityManager.merge(entity);
        transaction.commit();
        entityManager.close();
        return entity;
    }
}
