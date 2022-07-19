package com.example.M4SummativeAynalemSandyHanan.controller;
import com.example.M4SummativeAynalemSandyHanan.model.Console;
import com.example.M4SummativeAynalemSandyHanan.repository.ConsoleRepository;
import com.example.M4SummativeAynalemSandyHanan.service.ServiceLayer;
import com.example.M4SummativeAynalemSandyHanan.viewmodel.ConsoleViewModel;
import com.example.M4SummativeAynalemSandyHanan.viewmodel.InvoiceViewModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


@RestController
public class ConsoleController {

    @Autowired
    ServiceLayer serviceLayer;

    // As a user, I would like to be able to create, read, update and delete console information.
    @RequestMapping(value = "/console", method = RequestMethod.GET)
    @ResponseStatus(HttpStatus.OK)
    public List<ConsoleViewModel> getAllConsoles() {
        return serviceLayer.findAllConsoles();
    }

    @RequestMapping(value = "/manufacturer/{manufacturer}", method = RequestMethod.GET)
    @ResponseStatus(HttpStatus.OK)
    public List<ConsoleViewModel> getConsoleByManufacturer(@PathVariable String manufacturer) {
        return serviceLayer.findAllByConsoleManufacturer(manufacturer);
    }

    @RequestMapping(value = "/console/{id}", method = RequestMethod.GET)
    @ResponseStatus(HttpStatus.OK)
    public ConsoleViewModel getConsolById(@PathVariable @Valid int id) {
        return serviceLayer.findConsoleById(id);
    }

    @RequestMapping(value = "/console", method = RequestMethod.POST)
    @ResponseStatus(HttpStatus.CREATED)
    public ConsoleViewModel postConsole(@RequestBody ConsoleViewModel consoleViewModel) {
        return serviceLayer.saveConsole(consoleViewModel);
    }

    @RequestMapping(value = "/console/{id}", method = RequestMethod.PUT)
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void updateConsole(@PathVariable int id,@RequestBody ConsoleViewModel consoleViewModel) {
        if (consoleViewModel.getConsoleId() == null) {
            consoleViewModel.setConsoleId(id);
        } else if (consoleViewModel.getConsoleId() != id) {
            throw new IllegalArgumentException("Ids don't match.");
        }
        serviceLayer.updateConsole(consoleViewModel);
    }

    @RequestMapping(value="/console/{id}", method=RequestMethod.DELETE)
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteConsole(@PathVariable int id) {
        serviceLayer.removeConsole(id);
    }
}
