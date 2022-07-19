package com.example.M4SummativeAynalemSandyHanan.controller;
import com.example.M4SummativeAynalemSandyHanan.model.Game;
import com.example.M4SummativeAynalemSandyHanan.repository.GameRepository;
import com.example.M4SummativeAynalemSandyHanan.service.ServiceLayer;
import com.example.M4SummativeAynalemSandyHanan.viewmodel.GameViewModel;
import com.example.M4SummativeAynalemSandyHanan.viewmodel.InvoiceViewModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
public class GameController {
    @Autowired
    ServiceLayer serviceLayer;

    @RequestMapping(value = "/game", method = RequestMethod.GET)
    @ResponseStatus(HttpStatus.OK)
    public List<GameViewModel> getAllGames() {
        return serviceLayer.findAllGames();
    }

    @RequestMapping(value = "/game/{id}", method = RequestMethod.GET)
    @ResponseStatus(HttpStatus.OK)
    public GameViewModel getGameById(@PathVariable Integer id) {
        return serviceLayer.findGameById(id);
    }

    @RequestMapping(value = "/game/studio/{studio}", method = RequestMethod.GET)
    @ResponseStatus(HttpStatus.OK)
    public List<GameViewModel> findGamesByStudio(@PathVariable String studio) {
        return serviceLayer.findGamesByStudio(studio);
    }

    @RequestMapping(value = "/game/esrb/{esrbRating}", method = RequestMethod.GET)
    @ResponseStatus(HttpStatus.OK)
    public List<GameViewModel> findGamesByRating(@PathVariable String esrbRating) {
        return serviceLayer.findGamesByesrbRating(esrbRating);
    }

    @RequestMapping(value = "/game/title/{title}", method = RequestMethod.GET)
    @ResponseStatus(HttpStatus.OK)
    public List<GameViewModel> findGamesByTitle(@PathVariable String title) {
        return serviceLayer.findGamesByTitle(title);
    }

    @RequestMapping(value = "/game", method = RequestMethod.POST)
    @ResponseStatus(HttpStatus.CREATED)
    public GameViewModel addGame(@RequestBody GameViewModel gameViewModel) {
        return serviceLayer.saveGame(gameViewModel);
    }

    @RequestMapping(value = "/game/{id}", method = RequestMethod.PUT)
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void updateGame(@PathVariable int id,@RequestBody GameViewModel gameViewModel) {
        if (gameViewModel.getGameId() == null) {
            gameViewModel.setGameId(id);
        } else if (gameViewModel.getGameId() != id) {
            throw new IllegalArgumentException("Ids don't match.");
        }
        serviceLayer.updateGame(gameViewModel);
    }

    @RequestMapping(value="/game/{id}", method=RequestMethod.DELETE)
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteGame(@PathVariable Integer id) {
        serviceLayer.removeGame(id);
    }
}