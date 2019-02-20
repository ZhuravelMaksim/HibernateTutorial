package com.it.model;

import javax.persistence.*;

@Entity
@Table
@AttributeOverrides(@AttributeOverride(name = "name", column = @Column(name = "r_name")))
public class RegularEmployee extends Employee {

    private Double salary;

    private Integer bonus;

    public Double getSalary() {
        return salary;
    }

    public void setSalary(Double salary) {
        this.salary = salary;
    }

    public Integer getBonus() {
        return bonus;
    }

    public void setBonus(Integer bonus) {
        this.bonus = bonus;
    }
}
