package com.example.M4SummativeAynalemSandyHanan.model;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;

@Entity
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
@Table(name="t_shirt")
public class TShirt implements Serializable {
    @Id
    @Column(name = "t_shirt_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer tShirtId;
    private String color;
    private String size;
    private String description;
    private double price;
    private int quantity;

    public TShirt(){

    }

    public TShirt(String color, String size, Integer tShirtId, String description, double price, int quantity) {
        this.color = color;
        this.size = size;
        this.tShirtId = tShirtId;
        this.description = description;
        this.price = price;
        this.quantity = quantity;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public Integer getTShirtId() {
        return tShirtId;
    }

    public void setTShirtId(Integer tShirtId) {
        this.tShirtId = tShirtId;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TShirt tShirt = (TShirt) o;
        return tShirtId == tShirt.tShirtId && Double.compare(tShirt.price, price) == 0 && quantity == tShirt.quantity && Objects.equals(color, tShirt.color) && Objects.equals(size, tShirt.size) && Objects.equals(description, tShirt.description);
    }

    @Override
    public int hashCode() {
        return Objects.hash(color, size, tShirtId, description, price, quantity);
    }

    @Override
    public String toString() {
        return "TShirt{" +
                "color='" + color + '\'' +
                ", size='" + size + '\'' +
                ", tShirtId=" + tShirtId +
                ", description='" + description + '\'' +
                ", price=" + price +
                ", quantity=" + quantity +
                '}';
    }
}
