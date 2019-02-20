package com.it.dao.impl;

import com.it.dao.RegularEmployeeDAO;
import com.it.model.RegularEmployee;

public class RegularEmployeeDAOImpl extends GenericDAOImpl<RegularEmployee, Long> implements RegularEmployeeDAO {
    private static RegularEmployeeDAOImpl instance;

    private RegularEmployeeDAOImpl() {
        super(RegularEmployee.class);
    }

    synchronized public static RegularEmployeeDAOImpl getInstance() {
        if (instance == null) {
            instance = new RegularEmployeeDAOImpl();
        }
        return instance;
    }
}
