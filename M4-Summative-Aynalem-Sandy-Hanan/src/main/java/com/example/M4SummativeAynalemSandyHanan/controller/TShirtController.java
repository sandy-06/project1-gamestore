package com.example.M4SummativeAynalemSandyHanan.controller;

import com.example.M4SummativeAynalemSandyHanan.model.TShirt;
import com.example.M4SummativeAynalemSandyHanan.repository.TShirtRepository;
import com.example.M4SummativeAynalemSandyHanan.service.ServiceLayer;
import com.example.M4SummativeAynalemSandyHanan.viewmodel.GameViewModel;
import com.example.M4SummativeAynalemSandyHanan.viewmodel.InvoiceViewModel;
import com.example.M4SummativeAynalemSandyHanan.viewmodel.TShirtViewModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.io.Serializable;
import java.util.List;
import java.util.Optional;

@RestController
public class TShirtController {
    @Autowired
    ServiceLayer serviceLayer;

    @RequestMapping(value = "/tShirt", method = RequestMethod.GET)
    @ResponseStatus(HttpStatus.OK)
    public List<TShirtViewModel> getAllTShirts() {
        return serviceLayer.findAllTShirts();
    }

    @RequestMapping(value = "/tShirt/{id}", method = RequestMethod.GET)
    @ResponseStatus(HttpStatus.OK)
    public TShirtViewModel getTshirtById(@PathVariable int id) {
        return serviceLayer.findTShirtById(id);
    }

    @RequestMapping(value = "/tShirt/{id}", method = RequestMethod.PUT)
    @ResponseStatus(HttpStatus.OK)
    public void updateTShirt(@PathVariable int id, @RequestBody TShirtViewModel tshirtViewModel) {
        if (tshirtViewModel.gettShirtId() == null) {
            tshirtViewModel.settShirtId(id);
        } else if (tshirtViewModel.gettShirtId() != id) {
            throw new IllegalArgumentException("Ids don't match.");
        }
        serviceLayer.updateTShirt(tshirtViewModel);
    }

    @RequestMapping(value = "/tShirt/color/{color}", method = RequestMethod.GET)
    @ResponseStatus(HttpStatus.OK)
    public List<TShirtViewModel> findTShirtByColor(@PathVariable String color) {
        return serviceLayer.findTShirtByColor(color);
    }
    @RequestMapping(value = "/tShirt/size/{size}", method = RequestMethod.GET)
    @ResponseStatus(HttpStatus.OK)
    public List<TShirtViewModel> findTShirtBySize(@PathVariable String size) {
        return serviceLayer.findTShirtBySize(size);
    }
    @RequestMapping(value = "/tShirt", method = RequestMethod.POST)
    @ResponseStatus(HttpStatus.CREATED)
    public TShirtViewModel addTShirt(@RequestBody TShirtViewModel tShirtViewModel) {
        return serviceLayer.saveTShirt(tShirtViewModel);
    }

    @RequestMapping(value = "/tShirt/{id}", method = RequestMethod.DELETE)
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteTShirt(@PathVariable int id) {
        serviceLayer.removeTshirt(id);
    }

}
