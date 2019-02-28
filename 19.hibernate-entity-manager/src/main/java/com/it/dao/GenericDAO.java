package com.it.dao;

public interface GenericDAO<T,U> {

    T getOne(U id);

    void delete (U id);

    void save (T entity);

    T update (T entity);

}
