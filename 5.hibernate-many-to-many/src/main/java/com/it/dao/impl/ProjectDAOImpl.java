package com.it.dao.impl;

import com.it.dao.ProjectDAO;
import com.it.model.Project;

public class ProjectDAOImpl extends GenericDAOImpl<Project, Long> implements ProjectDAO {
    private static ProjectDAOImpl instance;

    private ProjectDAOImpl() {
        super(Project.class);
    }

    synchronized public static ProjectDAOImpl getInstance() {
        if (instance == null) {
            instance = new ProjectDAOImpl();
        }
        return instance;
    }
}
