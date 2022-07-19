package com.example.M4SummativeAynalemSandyHanan.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
import java.util.Objects;

@Entity
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
@Table(name="sales_tax_rate")
public class Taxes implements Serializable {
    @Id
    private String state;
    @Column(name= "rate")
    private double taxRate;

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public double getTaxRate() {
        return taxRate;
    }

    public void setTaxRate(double taxRate) {
        this.taxRate = taxRate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Taxes taxes = (Taxes) o;
        return Double.compare(taxes.taxRate, taxRate) == 0 && Objects.equals(state, taxes.state);
    }

    @Override
    public int hashCode() {
        return Objects.hash(state, taxRate);
    }

    @Override
    public String toString() {
        return "Taxes{" +
                "state='" + state + '\'' +
                ", taxRate=" + taxRate +
                '}';
    }
}
