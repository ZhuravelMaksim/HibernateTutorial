package com.it.model;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Set;

@Entity
@Table
public class Car {
    @Id
    private CarId id;

    @OneToMany(mappedBy = "car")
    private Set<Detail> details;


    private LocalDate dateOfManufacture;

    public CarId getId() {
        return id;
    }

    public void setId(CarId id) {
        this.id = id;
    }

    public Set<Detail> getDetails() {
        return details;
    }

    public void setDetails(Set<Detail> details) {
        this.details = details;
    }

    public LocalDate getDateOfManufacture() {
        return dateOfManufacture;
    }

    public void setDateOfManufacture(LocalDate dateOfManufacture) {
        this.dateOfManufacture = dateOfManufacture;
    }
}