package com.it.model;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("contractEmployee")
public class ContractEmployee extends Employee {

    private Double hourPay;

    private String contractDuration;


    public Double getHourPay() {
        return hourPay;
    }

    public void setHourPay(Double hourPay) {
        this.hourPay = hourPay;
    }

    public String getContractDuration() {
        return contractDuration;
    }

    public void setContractDuration(String contractDuration) {
        this.contractDuration = contractDuration;
    }
}
