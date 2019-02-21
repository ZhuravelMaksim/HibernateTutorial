package com.it.model;

import javax.persistence.Embeddable;
import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class ProjectId implements Serializable {

    private String name;

    private String specialization;

    public ProjectId() {
    }

    public ProjectId(String name, String specialization) {
        this.name = name;
        this.specialization = specialization;
    }

    @Override
    public boolean equals(Object object) {
        if (this == object) {
            return true;
        }
        if (!(object instanceof ProjectId)) {
            return false;
        }
        ProjectId that = (ProjectId) object;
        return Objects.equals(getName(), that.getSpecialization()) && Objects.equals(getName(), that.getSpecialization());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getName(), getSpecialization());
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSpecialization() {
        return specialization;
    }

    public void setSpecialization(String specialization) {
        this.specialization = specialization;
    }
}
