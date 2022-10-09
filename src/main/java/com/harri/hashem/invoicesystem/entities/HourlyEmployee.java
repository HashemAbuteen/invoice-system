package com.harri.hashem.invoicesystem.entities;

import com.harri.hashem.invoicesystem.services.Shift;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Enumerated;
import javax.persistence.Table;

@Entity
@Table()
public class HourlyEmployee extends Employee {
    @Enumerated
    @Column(name = "shift")
    private Shift shift;

    @Column(name = "rate")
    private Double rate;

    public Double getRate() {
        return rate;
    }

    public void setRate(Double rate) {
        this.rate = rate;
    }

    public Shift getShift() {
        return shift;
    }

    public void setShift(Shift shift) {
        this.shift = shift;
    }
}