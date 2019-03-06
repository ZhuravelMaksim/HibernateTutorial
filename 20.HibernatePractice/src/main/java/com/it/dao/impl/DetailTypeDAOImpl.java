package com.it.dao.impl;

import com.it.dao.DetailTypeDAO;
import com.it.model.Car;
import com.it.model.DetailType;

public class DetailTypeDAOImpl extends GenericDAOImpl<DetailType, Long> implements DetailTypeDAO {
    private static DetailTypeDAOImpl instance;

    private DetailTypeDAOImpl() {
        super(DetailType.class);
    }

    synchronized public static DetailTypeDAOImpl getInstance() {
        if (instance == null) {
            instance = new DetailTypeDAOImpl();
        }
        return instance;
    }
}
