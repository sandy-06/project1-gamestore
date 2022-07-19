package com.example.M4SummativeAynalemSandyHanan.repository;

import com.example.M4SummativeAynalemSandyHanan.model.Game;
import com.example.M4SummativeAynalemSandyHanan.service.ServiceLayer;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;
import java.util.Optional;

import static org.junit.Assert.*;
import static org.mockito.Mockito.doReturn;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class GameRepositoryTest {

    @Autowired
    GameRepository gameRepository;

    @Before
    public void setUp() throws Exception {
        gameRepository.deleteAll();

    }

    @Test
    public void addGetDeleteGame() {
        Game game = new Game();
        game.setStudio("xyz");
        game.setTitle("ninja3");
        game.setPrice(20);
        game.setEsrbRating("M");
        game.setDescription("zzzzzzzzzzzzzzz");
        game.setQuantity(2);

        game = gameRepository.save(game);

        Optional<Game> game1 = gameRepository.findById(game.getGameId());

        assertEquals(game1.get(), game);

        game1 = gameRepository.findById(game.getGameId());

        assertTrue(game1.isPresent());
    }

    @Test
    public void updateGame() {
        Game game = new Game();
        game.setStudio("xyz");
        game.setTitle("ninja3");
        game.setPrice(20);
        game.setEsrbRating("M");
        game.setDescription("zzzzzzzzzzzzzzz");
        game.setQuantity(2);

        game = gameRepository.save(game);

        game.setStudio("xyz");
        game.setTitle("spiderman");
        game.setPrice(200);
        game.setEsrbRating("M");
        game.setDescription("zzzzzzzzzzzzzzz");
        game.setQuantity(2);

        gameRepository.save(game);

        Optional<Game> game1 = gameRepository.findById(game.getGameId());
        assertEquals(game1.get(), game);

    }

    @Test
    public void getAllGames() {
        Game game = new Game();
        game.setStudio("xyz");
        game.setTitle("ninja3");
        game.setPrice(20);
        game.setEsrbRating("M");
        game.setDescription("zzzzzzzzzzzzzzz");
        game.setQuantity(2);

        game = gameRepository.save(game);

        game = new Game();
        game.setStudio("xyz");
        game.setTitle("ninja3");
        game.setPrice(20);
        game.setEsrbRating("M");
        game.setDescription("zzzzzzzzzzzzzzz");
        game.setQuantity(2);

        game = gameRepository.save(game);

        List<Game> gList = gameRepository.findAll();
        assertEquals(gList.size(), 2);


    }

    @Test
    public void getGamesByStudio() {
        Game game = new Game();
        game.setStudio("xyz");
        game.setTitle("ninja3");
        game.setPrice(20);
        game.setEsrbRating("M");
        game.setDescription("zzzzzzzzzzzzzzz");
        game.setQuantity(2);

        List<Game> game1 = gameRepository.findGamesByStudio(game.getStudio());

    }

    @Test
    public void getGamesByEsrbRating() {
        Game game = new Game();
        game.setStudio("xyz");
        game.setTitle("ninja3");
        game.setPrice(20);
        game.setEsrbRating("M");
        game.setDescription("zzzzzzzzzzzzzzz");
        game.setQuantity(2);

        List<Game> game1 = gameRepository.findGamesByesrbRating(game.getStudio());

    }

    @Test
    public void getGamesByTitle() {
        Game game = new Game();
        game.setStudio("xyz");
        game.setTitle("ninja3");
        game.setPrice(20);
        game.setEsrbRating("M");
        game.setDescription("zzzzzzzzzzzzzzz");
        game.setQuantity(2);

       List<Game> game1 = gameRepository.findGamesByTitle(game.getStudio());

    }
}