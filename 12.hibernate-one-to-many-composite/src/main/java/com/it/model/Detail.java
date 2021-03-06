package com.it.model;

import javax.persistence.*;

@Entity
@Table
public class Detail {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumns({@JoinColumn(name = "car_model", referencedColumnName = "model"),
            @JoinColumn(name = "car_producer", referencedColumnName = "producer")})
    private Car car;

    private String name;

    private String code;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Car getCar() {
        return car;
    }

    public void setCar(Car car) {
        this.car = car;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }
}