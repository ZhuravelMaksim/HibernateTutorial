package com.it.dao.impl;

import com.it.dao.ContractEmployeeDAO;
import com.it.model.ContractEmployee;

public class ContractEmployeeDAOImpl extends GenericDAOImpl<ContractEmployee, Long> implements ContractEmployeeDAO {
    private static ContractEmployeeDAOImpl instance;

    private ContractEmployeeDAOImpl() {
        super(ContractEmployee.class);
    }

    synchronized public static ContractEmployeeDAOImpl getInstance() {
        if (instance == null) {
            instance = new ContractEmployeeDAOImpl();
        }
        return instance;
    }
}
