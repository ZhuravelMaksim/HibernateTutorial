package com.it.dao.impl;

import com.it.dao.SupplierDAO;
import com.it.model.Supplier;

public class SupplierDAOImpl extends GenericDAOImpl<Supplier, Long> implements SupplierDAO {
    private static SupplierDAOImpl instance;

    private SupplierDAOImpl() {
        super(Supplier.class);
    }

    synchronized public static SupplierDAOImpl getInstance() {
        if (instance == null) {
            instance = new SupplierDAOImpl();
        }
        return instance;
    }
}
