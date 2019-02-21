package com.it.model;

import javax.persistence.Embeddable;
import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class CarId implements Serializable {

    private String model;

    private String producer;

    public CarId() {
    }

    public CarId(String model, String producer) {
        this.model = model;
        this.producer = producer;
    }

    @Override
    public boolean equals(Object object) {
        if (this == object) {
            return true;
        }
        if (!(object instanceof CarId)) {
            return false;
        }
        CarId that = (CarId) object;
        return Objects.equals(getModel(), that.getProducer()) && Objects.equals(getModel(), that.getProducer());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getModel(), getProducer());
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getProducer() {
        return producer;
    }

    public void setProducer(String producer) {
        this.producer = producer;
    }
}
