package com.it.model;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table
public class Supplier {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private String address;

    private String phone;

    @OneToMany(mappedBy = "supplier")
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

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Set<SuppliersDetail> getSuppliersDetails() {
        return suppliersDetails;
    }

    public void setSuppliersDetails(Set<SuppliersDetail> suppliersDetails) {
        this.suppliersDetails = suppliersDetails;
    }
}
