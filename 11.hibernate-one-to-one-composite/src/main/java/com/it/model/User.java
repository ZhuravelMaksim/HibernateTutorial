package com.it.model;

import javax.persistence.*;

@Entity
@Table
public class User {
    @Id
    private UserId id;

    private Integer age;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumns(@JoinColumn(name = "address_id", referencedColumnName = "id"))
    private Address address;

    public UserId getId() {
        return id;
    }

    public void setId(UserId id) {
        this.id = id;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }
}