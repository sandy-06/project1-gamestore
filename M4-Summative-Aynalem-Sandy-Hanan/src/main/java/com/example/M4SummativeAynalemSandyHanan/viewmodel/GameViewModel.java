package com.example.M4SummativeAynalemSandyHanan.viewmodel;

import com.example.M4SummativeAynalemSandyHanan.model.Game;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class GameViewModel {
    @Id//field is going to be pk
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer gameId;
    private String studio;
    private String esrbRating;
    private String title;
    private String description;
    private double price;
    private int quantity;

    private List<Game> game = new ArrayList<>();

    public GameViewModel(Integer gameId, String studio, String esrbRating, String title, String description, double price, int quantity, List<Game> game) {
        this.gameId = gameId;
        this.studio = studio;
        this.esrbRating = esrbRating;
        this.title = title;
        this.description = description;
        this.price = price;
        this.quantity = quantity;
        this.game = game;
    }

    public GameViewModel(String studio, String esrbRating, String title, String description, double price, int quantity) {

        this.studio = studio;
        this.esrbRating = esrbRating;
        this.title = title;
        this.description = description;
        this.price = price;
        this.quantity = quantity;
    }
    public GameViewModel(){

    }

    public Integer getGameId() {
        return gameId;
    }

    public void setGameId(Integer gameId) {
        this.gameId = gameId;
    }

    public String getStudio() {
        return studio;
    }

    public void setStudio(String studio) {
        this.studio = studio;
    }

    public String getEsrbRating() {
        return esrbRating;
    }

    public void setEsrbRating(String esrbRating) {
        this.esrbRating = esrbRating;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
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
        GameViewModel that = (GameViewModel) o;
        return esrbRating == that.esrbRating && Double.compare(that.price, price) == 0 && quantity == that.quantity && Objects.equals(gameId, that.gameId) && Objects.equals(studio, that.studio) && Objects.equals(title, that.title) && Objects.equals(description, that.description);
    }

    @Override
    public int hashCode() {
        return Objects.hash(gameId, studio, esrbRating, title, description, price, quantity);
    }
}
