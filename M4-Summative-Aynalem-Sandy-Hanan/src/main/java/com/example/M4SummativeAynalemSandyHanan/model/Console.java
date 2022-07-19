package com.example.M4SummativeAynalemSandyHanan.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;

@Entity
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
@Table(name="console")
public class Console implements Serializable { // serializable an interface to use java object in serialized form.
                                               // to be able to Consol as a string
    @Id
    @Column(name="console_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer consoleId;
    private String manufacturer;
    private String model;
    private double price;
    private int quantity;
    private String processor;
    @Column(name="memory_amount")
    private String memoryAmount;

    public Console(){

    }

    public Console(Integer consoleId, String manufacturer, String model, double price, int quantity, String processor, String memoryAmount) {
        this.consoleId = consoleId;
        this.manufacturer = manufacturer;
        this.model = model;
        this.price = price;
        this.quantity = quantity;
        this.processor = processor;
        this.memoryAmount = memoryAmount;
    }

    public Integer getConsoleId() {
        return consoleId;
    }

    public void setConsoleId(Integer consoleId) {
        this.consoleId = consoleId;
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
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

    public String getProcessor() {
        return processor;
    }

    public void setProcessor(String processor) {
        this.processor = processor;
    }

    public String getMemoryAmount() {
        return memoryAmount;
    }

    public void setMemoryAmount(String memoryAmount) {
        this.memoryAmount = memoryAmount;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Console console = (Console) o;
        return Double.compare(console.price, price) == 0 && quantity == console.quantity && Objects.equals(consoleId, console.consoleId) && Objects.equals(manufacturer, console.manufacturer) && Objects.equals(model, console.model) && Objects.equals(processor, console.processor) && Objects.equals(memoryAmount, console.memoryAmount);
    }

    @Override
    public int hashCode() {
        return Objects.hash(consoleId, manufacturer, model, price, quantity, processor, memoryAmount);
    }

    @Override
    public String toString() {
        return "Console{" +
                "consoleId=" + consoleId +
                ", manufacturer='" + manufacturer + '\'' +
                ", model='" + model + '\'' +
                ", price=" + price +
                ", quantity=" + quantity +
                ", processor='" + processor + '\'' +
                ", memoryAmount='" + memoryAmount + '\'' +
                '}';
    }
}
