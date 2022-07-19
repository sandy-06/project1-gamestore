package com.example.M4SummativeAynalemSandyHanan.viewmodel;

import com.example.M4SummativeAynalemSandyHanan.model.Console;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.ArrayList;
import java.util.Objects;

public class ConsoleViewModel {
    @Id//field is going to be pk
    @Column(name = "console_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer consoleId;
    private String consoleManufacturer;
    private String consoleModel;
    private double consolePrice;
    private int consoleQuantity;
    private String consoleProcessor;
    private String consoleMemory;


//    private List<Console> console = new ArrayList<>();


    public Integer getConsoleId() {
        return consoleId;
    }

    public void setConsoleId(Integer consoleId) {
        this.consoleId = consoleId;
    }

        public String getConsoleManufacturer() {
        return consoleManufacturer;
    }

    public void setConsoleManufacturer(String consoleManufacturer) {
        this.consoleManufacturer = consoleManufacturer;
    }

    public String getConsoleModel() {
        return consoleModel;
    }

    public void setConsoleModel(String consoleModel) {
        this.consoleModel = consoleModel;
    }

    public double getConsolePrice() {
        return consolePrice;
    }

    public void setConsolePrice(double consolePrice) {
        this.consolePrice = consolePrice;
    }

    public int getConsoleQuantity() {
        return consoleQuantity;
    }

    public void setConsoleQuantity(int consoleQuantity) {
        this.consoleQuantity = consoleQuantity;
    }

    public String getConsoleProcessor() {
        return consoleProcessor;
    }

    public void setConsoleProcessor(String consoleProcessor) {
        this.consoleProcessor = consoleProcessor;
    }

    public String getConsoleMemory() {
        return consoleMemory;
    }

    public void setConsoleMemory(String consoleMemory) {
        this.consoleMemory = consoleMemory;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ConsoleViewModel that = (ConsoleViewModel) o;
        return Double.compare(that.consolePrice, consolePrice) == 0 && consoleQuantity == that.consoleQuantity && Objects.equals(consoleId, that.consoleId) && Objects.equals(consoleManufacturer, that.consoleManufacturer) && Objects.equals(consoleModel, that.consoleModel) && Objects.equals(consoleProcessor, that.consoleProcessor) && Objects.equals(consoleMemory, that.consoleMemory);
    }

    @Override
    public int hashCode() {
        return Objects.hash(consoleId, consoleManufacturer, consoleModel, consolePrice, consoleQuantity, consoleProcessor, consoleMemory);
    }
}