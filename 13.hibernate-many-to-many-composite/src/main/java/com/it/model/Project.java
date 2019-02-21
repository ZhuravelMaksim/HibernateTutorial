package com.it.model;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Set;

@Entity
@Table(name = "Project")
public class Project {
    @Id
    private ProjectId id;

    @ManyToMany(mappedBy = "projects", fetch = FetchType.EAGER)
    private Set<Employee> employees;

    public ProjectId getId() {
        return id;
    }

    public void setId(ProjectId id) {
        this.id = id;
    }

    public Set<Employee> getEmployees() {
        return employees;
    }

    public void setEmployees(Set<Employee> employees) {
        this.employees = employees;
    }

}