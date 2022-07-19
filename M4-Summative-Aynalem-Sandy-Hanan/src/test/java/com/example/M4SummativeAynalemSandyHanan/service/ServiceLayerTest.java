package com.example.M4SummativeAynalemSandyHanan.service;

import com.example.M4SummativeAynalemSandyHanan.model.Console;
import com.example.M4SummativeAynalemSandyHanan.model.Game;
import com.example.M4SummativeAynalemSandyHanan.model.Invoice;
import com.example.M4SummativeAynalemSandyHanan.model.TShirt;
import com.example.M4SummativeAynalemSandyHanan.repository.*;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.mock; //allows to make a mock version of an obj


public class ServiceLayerTest {

    ServiceLayer service;
    ConsoleRepository consoleRepository;
    GameRepository gameRepository;
    TShirtRepository tShirtRepository;
    InvoiceRepository invoiceRepository;
    ProcessingFeeRepository processingFeeRepository;
    TaxesRepository taxesRepository;

    @Before
    public void setUp() throws Exception{
          setUpConsoleRepositoryMock();
          setUpGameRepositoryMock();
          setUpTShirtRepositoryMock();
          setUpInvoiceRepositoryMock();
//        setUpProcessingFeeRepository();
//        setUpTaxesRepository();

       // service = new ServiceLayer(consoleRepository,gameRepository,tShirtRepository);
                //invoiceRepository,processingFeeRepository,taxesRepository);


     // service = new ServiceLayer(consoleRepository);

        Console console2 = new Console();
        console2.setConsoleId(1);
        console2.setModel("model2");
        console2.setManufacturer("sony");
        console2.setMemoryAmount("4GB");
        console2.setProcessor("Windows");
        console2.setPrice(500);
        console2.setQuantity(2);

        System.out.println("ConsoleRepository.save(console) returns " + consoleRepository.save(console2));
        System.out.println("ConsoleRepository.findById(console) returns " + consoleRepository.findById(1));
        System.out.println("ConsoleRepository.findAll(console) returns" + consoleRepository.findAll());

       // service = new ServiceLayer(gameRepository);

        Game game2 = new Game();
        game2.setGameId(1);
        game2.setStudio("xyz");
        game2.setTitle("ninja3");
        game2.setPrice(20);
        game2.setEsrbRating("M");
        game2.setDescription("zzzzzzzzzzzzzzz");
        game2.setQuantity(2);

        System.out.println("GameRepository.save(game) returns " + gameRepository.save(game2));
        System.out.println("GameRepository.findById(game) returns " + gameRepository.findById(1));
        System.out.println("GameRepository.findAll(game) returns" + gameRepository.findAll());


       // service = new ServiceLayer(tShirtRepository);

        TShirt tshirt2 = new TShirt();
        tshirt2.setTShirtId(1);
        tshirt2.setSize("S");
        tshirt2.setColor("Red");
        tshirt2.setDescription("Test Description");
        tshirt2.setPrice(19.50);
        tshirt2.setQuantity(1);

        System.out.println("TShirtRepository.save(game) returns " + tShirtRepository.save(tshirt2));
        System.out.println("TShirtRepository.findById(game) returns " + tShirtRepository.findById(1));
        System.out.println("TShirtRepository.findAll(game) returns" + tShirtRepository.findAll());

        Invoice invoice2 = new Invoice();
        invoice2.setInvoiceId(1);
        invoice2.setItemId(2);
        invoice2.setName("Hanan");
        invoice2.setStreet("21 wonderland");
        invoice2.setCity("Richmond");
        invoice2.setState("VA");
        invoice2.setZipcode("49922");
        invoice2.setUnitPrice(500);
        invoice2.setItemType("console");
        invoice2.setQuantity(1);
//        invoice2.setSubtotal();
//        invoice2.setTax();
        invoice2.getProcessingFee();
       // invoice2.setTotal();

        System.out.println("InvoiceRepository.save(invoice) returns " + invoiceRepository.save(invoice2));
        System.out.println("InvoiceRepository.findById(invoice) returns " + invoiceRepository.findById(1));
        System.out.println("InvoiceRepository.findAll(invoice) returns" + invoiceRepository.findAll());
    }

    @Test
public void consoleTestSetUp(){
    System.out.println("something");
}
    private void setUpConsoleRepositoryMock() {
        //mock version of console repo and got all its methods
        consoleRepository = mock(ConsoleRepository.class);//when console is saved it will give me consol2
        Console console = new Console();
        console.setConsoleId(1);
        console.setModel("model2");
        console.setManufacturer("Sony");
        console.setMemoryAmount("4GB");
        console.setProcessor("Windows");
        console.setPrice(500);
        console.setQuantity(2);


        Console console2 = new Console();
        console2.setConsoleId(1);
        console2.setModel("model2");
        console2.setManufacturer("Sony");
        console2.setMemoryAmount("4GB");
        console2.setProcessor("Windows");
        console2.setPrice(500);
        console2.setQuantity(2);


        List<Console> cList = new ArrayList<>();
        cList.add(console);
        doReturn(console).when(consoleRepository).save(console2);//Assert/compare console1 and console2
        doReturn(Optional.of(console)).when(consoleRepository).findById(1);
        doReturn(cList).when(consoleRepository).findAll();


    }

    @Test
    public void gameTestSetUp(){
        System.out.println("something");
    }
    private void setUpGameRepositoryMock() {
        gameRepository = mock(GameRepository.class);//when game is saved it will give me game2
        Game game = new Game();
        game.setGameId(1);
        game.setStudio("xyz");
        game.setTitle("ninja3");
        game.setPrice(20);
        game.setEsrbRating("M");
        game.setDescription("zzzzzzzzzzzzzzz");
        game.setQuantity(2);

        Game game2 = new Game();
        game2.setGameId(1);
        game2.setStudio("xyz");
        game2.setTitle("ninja3");
        game2.setPrice(20);
        game2.setEsrbRating("M");
        game2.setDescription("zzzzzzzzzzzzzzz");
        game2.setQuantity(2);

        List<Game> gList = new ArrayList<>();
        gList.add(game);
        doReturn(game).when(gameRepository).save(game2);//Assert/compare game1 and game2
        doReturn(Optional.of(game)).when(gameRepository).findById(1);
        doReturn(gList).when(gameRepository).findAll();


    }


    @Test
    public void tshirtTestSetUp(){
        System.out.println("something");
    }
    private void setUpTShirtRepositoryMock() {
           tShirtRepository = mock(TShirtRepository.class);//when tshirt is saved it will give me tshirt1
           TShirt tshirt = new TShirt();
           tshirt.setTShirtId(1);
           tshirt.setSize("S");
           tshirt.setColor("Red");
           tshirt.setDescription("Test Description");
           tshirt.setPrice(19.50);
           tshirt.setQuantity(1);

            TShirt tshirt2 = new TShirt();
            tshirt2.setTShirtId(1);
            tshirt2.setSize("S");
            tshirt2.setColor("Red");
            tshirt2.setDescription("Test Description");
            tshirt2.setPrice(19.50);
            tshirt2.setQuantity(1);

            List<TShirt> tList = new ArrayList<>();
            tList.add(tshirt);
            doReturn(tshirt).when(tShirtRepository).save(tshirt2);//Assert/compare tshirt1 and tshirt2. if i save tshirt2 give me tshirt1
            doReturn(Optional.of(tshirt)).when(tShirtRepository).findById(1);
            doReturn(tList).when(tShirtRepository).findAll();

        }

    @Test
    public void invoiceTestSetUp(){
        System.out.println("something");
    }
    private void setUpInvoiceRepositoryMock() {
    invoiceRepository = mock(InvoiceRepository.class);//when tshirt is saved it will give me tshirt1
        Invoice invoice = new Invoice();
        invoice.setInvoiceId(1);
        invoice.setItemId(2);
        invoice.setName("Hanan");
        invoice.setStreet("21 wonderland");
        invoice.setCity("Richmond");
        invoice.setState("VA");
        invoice.setZipcode("49922");
        invoice.setUnitPrice(500);
        invoice.setItemType("console");
        invoice.setQuantity(1);
//        invoice.setSubtotal();
//        invoice.setTax();
        invoice.getProcessingFee();
        //invoice.setTotal();


        Invoice invoice2 = new Invoice();
        invoice2.setInvoiceId(1);
        invoice2.setItemId(2);
        invoice2.setName("Hanan");
        invoice2.setStreet("21 wonderland");
        invoice2.setCity("Richmond");
        invoice2.setState("VA");
        invoice2.setZipcode("49922");
        invoice2.setUnitPrice(500);
        invoice2.setItemType("console");
        invoice2.setQuantity(1);
//        invoice2.setSubtotal();
//        invoice2.setTax();
        invoice2.getProcessingFee();
       // invoice2.setTotal();

        List<Invoice> iList = new ArrayList<>();
        iList.add(invoice);
        doReturn(invoice).when(invoiceRepository).save(invoice2);//Assert/compare tshirt1 and tshirt2. if i save tshirt2 give me tshirt1
        doReturn(Optional.of(invoice)).when(tShirtRepository).findById(1);
        doReturn(iList).when(tShirtRepository).findAll();

  }
//
//    private void setUpProcessingFeeRepository() {
//
//    }
//    private void setUpTaxesRepository() {
//
//    }
//





}