package com.example.M4SummativeAynalemSandyHanan.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import java.io.Serializable;
import java.util.Objects;

@Entity
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
@Table(name="game")
public class Game implements Serializable {

    @Id//field is going to be pk
    @Column(name = "game_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer gameId;
   // @NotEmpty(message = "You must supply a value for studio")
    private String studio;
  //  @NotEmpty(message = "You must supply a value for rating")
  @Column(name = "esrb_rating")
    private String esrbRating;
   // @NotEmpty(message = "You must supply a value for title")
    private String title;
    private String description;
    private double price;
    private int quantity;

    public Game(){

    }
    public Game(Integer gameId, String studio, String esrbRating, String title, String description, double price, int quantity) {
        this.gameId = gameId;
        this.studio = studio;
        this.esrbRating = esrbRating;
        this.title = title;
        this.description = description;
        this.price = price;
        this.quantity = quantity;
    }

    public Game(String studio, String esrbRating, String title, String description, double price, int quantity) {

        this.studio = studio;
        this.esrbRating = esrbRating;
        this.title = title;
        this.description = description;
        this.price = price;
        this.quantity = quantity;
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
        Game game = (Game) o;
        return Double.compare(game.price, price) == 0 && quantity == game.quantity && Objects.equals(gameId, game.gameId) && Objects.equals(studio, game.studio) && Objects.equals(esrbRating, game.esrbRating) && Objects.equals(title, game.title) && Objects.equals(description, game.description);
    }

    @Override
    public int hashCode() {
        return Objects.hash(gameId, studio, esrbRating, title, description, price, quantity);
    }

    @Override
    public String toString() {
        return "Game{" +
                "gameId=" + gameId +
                ", studio='" + studio + '\'' +
                ", esrbRating=" + esrbRating +
                ", title='" + title + '\'' +
                ", description='" + description + '\'' +
                ", price=" + price +
                ", quantity=" + quantity +
                '}';
    }
}
