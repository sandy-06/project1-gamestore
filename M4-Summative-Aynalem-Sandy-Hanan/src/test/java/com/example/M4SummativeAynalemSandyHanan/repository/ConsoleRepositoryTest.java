package com.example.M4SummativeAynalemSandyHanan.repository;

import com.example.M4SummativeAynalemSandyHanan.model.Console;
import com.example.M4SummativeAynalemSandyHanan.model.Game;
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
public class ConsoleRepositoryTest {

    @Autowired
    ConsoleRepository consoleRepository;

    @Before
    public void setUp() throws Exception {
        consoleRepository.deleteAll();

    }

    @Test
    public void addGetDeleteConsole(){
        Console console = new Console();
            console.setModel("Playstation 4");
            console.setManufacturer("Sony");
            console.setMemoryAmount("8GB");
            console.setProcessor("Dual Core");
            console.setPrice(299.99);
            console.setQuantity(5);

        console = consoleRepository.save(console);//save in db + new id from the db

        Optional<Console> console1 = consoleRepository.findById(console.getConsoleId());//get the console from & id from the db and put it on console1

        assertEquals(console1.get(), console);

        console1 = consoleRepository.findById(console.getConsoleId());

        assertTrue(console1.isPresent());
    }

    @Test
    public void updateConsole(){
//Arrange
        Console console = new Console();
        console.setModel("Playstation 4");
        console.setManufacturer("Sony");
        console.setMemoryAmount("8GB");
        console.setProcessor("Dual Core");
        console.setPrice(299.99);
        console.setQuantity(5);

        console = consoleRepository.save(console);


        console.setModel("Playstation 4");
        console.setManufacturer("Sony");
        console.setMemoryAmount("8GB");
        console.setProcessor("Dual Core");
        console.setPrice(100);
        console.setQuantity(1);
//Act
        consoleRepository.save(console);

//Assert
        Optional<Console> console1 = consoleRepository.findById(console.getConsoleId());
        assertEquals(console1.get(), console);

    }

    @Test
    public void getAllConsole(){
        Console console = new Console();
        console.setModel("Playstation 4");
        console.setManufacturer("Sony");
        console.setMemoryAmount("8GB");
        console.setProcessor("Dual Core");
        console.setPrice(299.99);
        console.setQuantity(5);

        console = consoleRepository.save(console);

        console = new Console();
        console.setModel("Playstation 4");
        console.setManufacturer("Sony");
        console.setMemoryAmount("8GB");
        console.setProcessor("Dual Core");
        console.setPrice(299.99);
        console.setQuantity(5);

        console = consoleRepository.save(console);

        List<Console> cList = consoleRepository.findAll();
        assertEquals(cList.size(), 2);


    }

    @Test
    public void getConsoleByManufacturer(){

        Console console = new Console();
        console.setModel("Playstation 4");
        console.setManufacturer("Sony");
        console.setMemoryAmount("8GB");
        console.setProcessor("Dual Core");
        console.setPrice(299.99);
        console.setQuantity(5);

        List<Console> console1 = consoleRepository.findAllByManufacturer(console.getManufacturer());

    }
}
