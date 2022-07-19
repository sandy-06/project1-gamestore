package com.example.M4SummativeAynalemSandyHanan.viewmodel;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Objects;

public class TShirtViewModel {

    private Integer tShirtId;
    private String color;
    private String size;
    private String description;
    private double price;
    private int quantity;

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

    public Integer gettShirtId() {
        return tShirtId;
    }

    public void settShirtId(Integer tShirtId) {
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
        TShirtViewModel that = (TShirtViewModel) o;
        return tShirtId == that.tShirtId && Double.compare(that.price, price) == 0 && quantity == that.quantity && Objects.equals(color, that.color) && Objects.equals(size, that.size) && Objects.equals(description, that.description);
    }

    @Override
    public int hashCode() {
        return Objects.hash(color, size, tShirtId, description, price, quantity);
    }
}
