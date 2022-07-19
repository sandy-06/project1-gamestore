package com.example.M4SummativeAynalemSandyHanan.repository;

import com.example.M4SummativeAynalemSandyHanan.model.TShirt;
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
public class TShirtRepositoryTest {

    @Autowired
    TShirtRepository tShirtRepository;

    @Before
    public void setUp() throws Exception {
        tShirtRepository.deleteAll();

    }

    @Test
    public void addGetDeleteTShirt() {

        TShirt tShirt = new TShirt();
        tShirt.setSize("S");
        tShirt.setColor("Red");
        tShirt.setDescription("Test Description");
        tShirt.setPrice(19.50);
        tShirt.setQuantity(1);

        tShirt = tShirtRepository.save(tShirt);

        Optional<TShirt> tShirt1 = tShirtRepository.findById(tShirt.getTShirtId());

        assertEquals(tShirt1.get(), tShirt);

        tShirt1 = tShirtRepository.findById(tShirt.getTShirtId());

        assertTrue(tShirt1.isPresent());
    }

    @Test
    public void updateTShirt() {

        TShirt tShirt = new TShirt();

        tShirt.setSize("S");
        tShirt.setColor("Red");
        tShirt.setDescription("Test Description");
        tShirt.setPrice(19.50);
        tShirt.setQuantity(1);

        tShirt = tShirtRepository.save(tShirt);


        tShirt.setSize("M");
        tShirt.setColor("Black");
        tShirt.setDescription("Test Description");
        tShirt.setPrice(19.50);
        tShirt.setQuantity(1);

        tShirtRepository.save(tShirt);

        Optional<TShirt> tShirt1 = tShirtRepository.findById(tShirt.getTShirtId());
        assertEquals(tShirt1.get(), tShirt);
    }

    @Test
    public void getAllTShirt() {

        TShirt tShirt = new TShirt();
        tShirt.setSize("S");
        tShirt.setColor("Red");
        tShirt.setDescription("Test Description");
        tShirt.setPrice(19.50);
        tShirt.setQuantity(1);

        tShirt = tShirtRepository.save(tShirt);

        tShirt = new TShirt();
        tShirt.setSize("S");
        tShirt.setColor("Red");
        tShirt.setDescription("Test Description");
        tShirt.setPrice(19.50);
        tShirt.setQuantity(1);

        tShirt = tShirtRepository.save(tShirt);

        List<TShirt> tList = tShirtRepository.findAll();
        assertEquals(tList.size(), 2);


    }

    @Test
    public void getTshirByColor() {

        TShirt tShirt = new TShirt();
        tShirt.setSize("S");
        tShirt.setColor("Red");
        tShirt.setDescription("Test Description");
        tShirt.setPrice(19.50);
        tShirt.setQuantity(1);

        List<TShirt> tShirt1 = tShirtRepository.findTShirtByColor(tShirt.getColor());

    }

    @Test
    public void getTshirBySize() {

        TShirt tShirt = new TShirt();
        tShirt.setSize("S");
        tShirt.setColor("Red");
        tShirt.setDescription("Test Description");
        tShirt.setPrice(19.50);
        tShirt.setQuantity(1);

      List<TShirt> tShirt1 = tShirtRepository.findTShirtBySize(tShirt.getSize());

    }
}
