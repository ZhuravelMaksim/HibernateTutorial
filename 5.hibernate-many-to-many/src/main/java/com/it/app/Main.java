package com.it.app;

import com.it.dao.EmployeeDAO;
import com.it.dao.ProjectDAO;
import com.it.dao.impl.EmployeeDAOImpl;
import com.it.dao.impl.ProjectDAOImpl;
import com.it.model.Employee;
import com.it.model.Project;

import java.util.HashSet;
import java.util.Set;

public class Main {
    private static final ProjectDAO projectDAO = ProjectDAOImpl.getInstance();
    private static final EmployeeDAO employeeDAO = EmployeeDAOImpl.getInstance();

    public static void main(String[] arguments) {
        createProject();
        Project persistProject = projectDAO.getOne(1L);
        Set<Project> projects = new HashSet<>();
        projects.add(persistProject);
        createEmployee(projects);
    }

    private static void createEmployee(Set<Project> projects) {
        Employee transientEmployee = new Employee();
        transientEmployee.setName("Bob Johnson");
        transientEmployee.setProjects(projects);
        employeeDAO.save(transientEmployee);
    }

    private static void createProject() {
        Project transientProject = new Project();
        transientProject.setName("Global Java Project");
        projectDAO.save(transientProject);
    }
}
