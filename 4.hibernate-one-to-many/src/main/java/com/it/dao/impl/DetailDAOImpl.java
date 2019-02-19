package com.it.dao.impl;

import com.it.dao.DetailDAO;
import com.it.model.Detail;

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
}
