package com.it.dao.impl;

import com.it.dao.SuppliersDetailDAO;
import com.it.model.SuppliersDetail;

public class SuppliersDetailDAOImpl extends GenericDAOImpl<SuppliersDetail, Long> implements SuppliersDetailDAO {
    private static SuppliersDetailDAOImpl instance;

    private SuppliersDetailDAOImpl() {
        super(SuppliersDetail.class);
    }

    synchronized public static SuppliersDetailDAOImpl getInstance() {
        if (instance == null) {
            instance = new SuppliersDetailDAOImpl();
        }
        return instance;
    }
}
