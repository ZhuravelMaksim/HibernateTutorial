package com.it.dao.impl;

import com.it.dao.AddressDAO;
import com.it.model.Address;

public class AddressDAOImpl extends GenericDAOImpl<Address, Long> implements AddressDAO {
    private static AddressDAOImpl instance;

    private AddressDAOImpl() {
        super(Address.class);
    }

    synchronized public static AddressDAOImpl getInstance() {
        if (instance == null) {
            instance = new AddressDAOImpl();
        }
        return instance;
    }
}
