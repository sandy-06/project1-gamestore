package com.example.M4SummativeAynalemSandyHanan.repository;

import com.example.M4SummativeAynalemSandyHanan.model.Console;
import com.example.M4SummativeAynalemSandyHanan.model.Game;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface GameRepository extends JpaRepository<Game, Integer> {

    List<Game> findGamesByStudio(String studio);//findGamebyStudio method whithout a body b/c its an interface
    List<Game> findGamesByesrbRating(String esrbRating);
    List<Game> findGamesByTitle(String title);

   }
