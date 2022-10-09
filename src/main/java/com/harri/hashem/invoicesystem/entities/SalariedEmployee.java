package com.harri.hashem.invoicesystem.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table()
public class SalariedEmployee extends Employee {
    @Column(name = "salary")
    private Double salary;

    @Column(name = "contract_years")
    private Double contractYears;

    public Double getContractYears() {
        return contractYears;
    }

    public void setContractYears(Double contractYears) {
        this.contractYears = contractYears;
    }

    public Double getSalary() {
        return salary;
    }

    public void setSalary(Double salary) {
        this.salary = salary;
    }
}