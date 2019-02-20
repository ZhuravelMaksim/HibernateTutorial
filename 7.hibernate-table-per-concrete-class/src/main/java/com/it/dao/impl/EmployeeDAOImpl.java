package com.it.dao.impl;

import com.it.dao.EmployeeDAO;
import com.it.model.Employee;

public class EmployeeDAOImpl extends GenericDAOImpl<Employee, Long> implements EmployeeDAO {
    private static EmployeeDAOImpl instance;

    private EmployeeDAOImpl() {
        super(Employee.class);
    }

    synchronized public static EmployeeDAOImpl getInstance() {
        if (instance == null) {
            instance = new EmployeeDAOImpl();
        }
        return instance;
    }
}
