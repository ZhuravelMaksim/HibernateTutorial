package com.it.app;

import com.it.dao.ContractEmployeeDAO;
import com.it.dao.EmployeeDAO;
import com.it.dao.RegularEmployeeDAO;
import com.it.dao.impl.ContractEmployeeDAOImpl;
import com.it.dao.impl.EmployeeDAOImpl;
import com.it.dao.impl.RegularEmployeeDAOImpl;
import com.it.model.ContractEmployee;
import com.it.model.Employee;
import com.it.model.RegularEmployee;

public class Main {
    private static final EmployeeDAO employeeDAO = EmployeeDAOImpl.getInstance();
    private static final RegularEmployeeDAO regularEmployeeDAO = RegularEmployeeDAOImpl.getInstance();
    private static final ContractEmployeeDAO contractEmployeeDAO = ContractEmployeeDAOImpl.getInstance();


    public static void main(String[] arguments) {
        performEmployeeOperations();
        performRegularEmployeeOperations();
        performContractEmployeeOperations();
    }


    private static void performEmployeeOperations() {
        Employee employee = employeeDAO.getOne(1L);
        if (employee == null) {
            employee = new Employee();
            employee.setName("Job Jobbins");
            employee.setAge(20);
            employeeDAO.save(employee);
        }
        Employee persistentEmployee = employeeDAO.getOne(1L);
        if (persistentEmployee != null) {
            System.out.println(persistentEmployee.getName());
            employeeDAO.delete(1L);
        }
    }

    private static void performRegularEmployeeOperations() {
        RegularEmployee regularEmployee = regularEmployeeDAO.getOne(2L);
        if (regularEmployee == null) {
            regularEmployee = new RegularEmployee();
            regularEmployee.setName("Rob Robbins");
            regularEmployee.setAge(21);
            regularEmployee.setBonus(1);
            regularEmployee.setSalary(200.0);
            regularEmployeeDAO.save(regularEmployee);
        }
        RegularEmployee persistentContractEmployee = regularEmployeeDAO.getOne(2L);
        if (persistentContractEmployee != null) {
            System.out.println(persistentContractEmployee.getName());
            regularEmployeeDAO.delete(1L);
        }
    }

    private static void performContractEmployeeOperations() {
        ContractEmployee contractEmployee = contractEmployeeDAO.getOne(3L);
        if (contractEmployee == null) {
            contractEmployee = new ContractEmployee();
            contractEmployee.setName("Bob Bobbins");
            contractEmployee.setAge(22);
            contractEmployee.setContractDuration("2020-01-01");
            contractEmployee.setHourPay(22.2);
            contractEmployeeDAO.save(contractEmployee);
        }
        ContractEmployee persistentContractEmployee = contractEmployeeDAO.getOne(3L);
        if (persistentContractEmployee != null) {
            System.out.println(persistentContractEmployee.getName());
            employeeDAO.delete(1L);
        }
    }
}
