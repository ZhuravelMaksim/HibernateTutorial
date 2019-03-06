package com.it.model;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table
public class Detail {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @ManyToMany(cascade = {CascadeType.ALL}, fetch = FetchType.LAZY)
    @JoinTable(name = "Detail_Car",
            joinColumns = {@JoinColumn(name = "detail_id")},
            inverseJoinColumns = {@JoinColumn(name = "car_id")})
    private Set<Car> cars;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "detail_type_id", nullable = false)
    private DetailType detailType;

    @OneToMany(mappedBy = "detail")
    private Set<SuppliersDetail> suppliersDetails;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public DetailType getDetailType() {
        return detailType;
    }

    public void setDetailType(DetailType detailType) {
        this.detailType = detailType;
    }

    public Set<Car> getCars() {
        return cars;
    }

    public void setCars(Set<Car> cars) {
        this.cars = cars;
    }

    public Set<SuppliersDetail> getSuppliersDetails() {
        return suppliersDetails;
    }

    public void setSuppliersDetails(Set<SuppliersDetail> suppliersDetails) {
        this.suppliersDetails = suppliersDetails;
    }
}
