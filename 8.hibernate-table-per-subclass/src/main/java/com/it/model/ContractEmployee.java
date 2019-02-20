package com.it.model;

import javax.persistence.*;

@Entity
@Table
@PrimaryKeyJoinColumn(name="employee_id")
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
