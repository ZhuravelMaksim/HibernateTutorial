package com.it.app;

import com.it.dao.EmployeeDAO;
import com.it.dao.ProjectDAO;
import com.it.dao.impl.EmployeeDAOImpl;
import com.it.dao.impl.ProjectDAOImpl;
import com.it.model.Employee;
import com.it.model.Project;
import com.it.model.ProjectId;

import java.util.HashSet;
import java.util.Set;

public class Main {
    private static final ProjectDAO projectDAO = ProjectDAOImpl.getInstance();
    private static final EmployeeDAO employeeDAO = EmployeeDAOImpl.getInstance();

    public static void main(String[] arguments) {
        ProjectId projectId = new ProjectId("PS", "IT");
        createProject(projectId);
        Project persistProject = projectDAO.getOne(projectId);
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

    private static void createProject(ProjectId id) {
        Project transientProject = new Project();
        transientProject.setId(id);
        projectDAO.save(transientProject);
    }
}
