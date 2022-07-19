package com.example.M4SummativeAynalemSandyHanan.service;
import com.example.M4SummativeAynalemSandyHanan.exceptions.NotFoundException;
import com.example.M4SummativeAynalemSandyHanan.model.*;
import com.example.M4SummativeAynalemSandyHanan.repository.*;
import com.example.M4SummativeAynalemSandyHanan.viewmodel.ConsoleViewModel;
import com.example.M4SummativeAynalemSandyHanan.viewmodel.GameViewModel;
import com.example.M4SummativeAynalemSandyHanan.viewmodel.InvoiceViewModel;
import com.example.M4SummativeAynalemSandyHanan.viewmodel.TShirtViewModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

//@Component //
@Service// is a component. when the app runs it creates instance of  component & we use it for dependency injection
public class ServiceLayer {

    ConsoleRepository consoleRepository;
    GameRepository gameRepository;
    TShirtRepository tShirtRepository;
    InvoiceRepository invoiceRepository;
    TaxesRepository taxesRepository;
    ProcessingFeeRepository processingFeeRepository;

    @Autowired
    public ServiceLayer(ConsoleRepository consoleRepository, GameRepository gameRepository, TShirtRepository tShirtRepository, InvoiceRepository invoiceRepository, TaxesRepository taxesRepository, ProcessingFeeRepository processingFeeRepository, GameRepository gameRepository1) {
        this.consoleRepository = consoleRepository;
        this.gameRepository = gameRepository;
        this.tShirtRepository = tShirtRepository;
        this.invoiceRepository = invoiceRepository;
        this.taxesRepository = taxesRepository;
        this.processingFeeRepository = processingFeeRepository;

    }

    public ServiceLayer(){

    }


    //Game
    @Transactional//allows us to updates the db several times in one method
    public GameViewModel saveGame(GameViewModel viewmodel) { //a method that returns GameViewmodel

  if(viewmodel == null){
    throw new IllegalArgumentException("invalid empty");
}

    Game g = new Game();//empty album
        //getting the data from viewmodel and put it in the game
        g.setTitle(viewmodel.getTitle());
        g.setStudio(viewmodel.getStudio());
        g.setDescription(viewmodel.getDescription());
        g.setPrice(viewmodel.getPrice());
        g.setEsrbRating(viewmodel.getEsrbRating());
        g.setQuantity(viewmodel.getQuantity());
     //   viewmodel.setGameId(g.getGameId());

         g = gameRepository.save(g);//it has an id. puting info in the db
         viewmodel.setGameId(g.getGameId()); //set the id to viewmodel
         return viewmodel;
}

    public GameViewModel findGameById(Integer id) {

           // Get the game object first
            Optional<Game> game = gameRepository.findById(id);

            return game.isPresent() ? buildGameViewModel(game.get()) : null;//if game is not present return null
        }

    private GameViewModel buildGameViewModel(Game viewmodel) {

            // Get the associated game
          //  Optional<Game> game = gameRepository.findById(viewmodel.getGameId());//optional may or may not have game in it
            // Assemble the GameViewModel
            GameViewModel gvm = new GameViewModel();
            gvm.setTitle(viewmodel.getTitle());
            gvm.setStudio(viewmodel.getStudio());
            gvm.setDescription(viewmodel.getDescription());
            gvm.setPrice(viewmodel.getPrice());
            gvm.setEsrbRating(viewmodel.getEsrbRating());
            gvm.setQuantity(viewmodel.getQuantity());
            gvm.setGameId(viewmodel.getGameId());


            // Return the GameViewModel
            return gvm;
        }

    public List<GameViewModel> findAllGames() {

        List<Game> gameList = gameRepository.findAll();//list of game w/t anything built

        List<GameViewModel> gvmList = new ArrayList<>(); //gameviewmodel got the info we want

        for (Game game : gameList) {
            GameViewModel gvm = buildGameViewModel(game);
            gvmList.add(gvm);
        }

        return gvmList;
    }

    @Transactional
    public void updateGame(GameViewModel viewmodel) { //creats a game from gameviewmodel & save it

        // Update the game information
        Game g = new Game();
        g.setTitle(viewmodel.getTitle());
        g.setStudio(viewmodel.getStudio());
        g.setDescription(viewmodel.getDescription());
        g.setPrice(viewmodel.getPrice());
        g.setEsrbRating(viewmodel.getEsrbRating());
        g.setQuantity(viewmodel.getQuantity());
        g.setGameId(viewmodel.getGameId());


        gameRepository.save(g);

    }

    @Transactional
    public void removeGame(Integer id) {

        gameRepository.deleteById(id);

    }

    public List<GameViewModel> findGamesByStudio(String studio){
        List<GameViewModel> returnEmptyList = new ArrayList<>();
        List<Game> findGameByStudio = gameRepository.findGamesByStudio(studio);

        for(Game game : findGameByStudio){
            returnEmptyList.add(buildGameViewModel(game));
        }
        return returnEmptyList;
    }

    public List<GameViewModel> findGamesByesrbRating(String esrbRate){
        List<GameViewModel> returnEmptyList = new ArrayList<>();
        List<Game> findGameByesrbRate = gameRepository.findGamesByesrbRating(esrbRate);

        for(Game game : findGameByesrbRate ){
            returnEmptyList.add(buildGameViewModel(game));
        }
        return returnEmptyList;
    }

    public List<GameViewModel> findGamesByTitle(String title){
        List<GameViewModel> returnEmptyList = new ArrayList<>();
        List<Game> findGameByTitle = gameRepository.findGamesByTitle(title);

        for(Game game : findGameByTitle ){
            returnEmptyList.add(buildGameViewModel(game));
        }
        return returnEmptyList;
    }



//TShirt
    @Transactional
    public TShirtViewModel saveTShirt(TShirtViewModel viewModel) {

        if(viewModel == null){
            throw new IllegalArgumentException("invalid empty");
        }

        TShirt t = new TShirt();
        t.setSize(viewModel.getSize());
        t.setColor(viewModel.getColor());
        t.setDescription(viewModel.getDescription());
        t.setPrice(viewModel.getPrice());
        t.setQuantity(viewModel.getQuantity());


        t = tShirtRepository.save(t);
        viewModel.settShirtId(t.getTShirtId());
        return viewModel;
    }

    public TShirtViewModel findTShirtById(int id) {

        // Get the game object first
        Optional<TShirt> tShirt = tShirtRepository.findById(id);

        return tShirt.isPresent() ? buildTShirtViewModel(tShirt.get()) : null;
    }

    private TShirtViewModel buildTShirtViewModel(TShirt tShirt) {

      //  Optional<TShirt> shirt = tShirtRepository.findById(tShirt.gettShirtId());
        TShirtViewModel tvm = new TShirtViewModel();
        tvm.setSize(tShirt.getSize());
        tvm.setColor(tShirt.getColor());
        tvm.setDescription(tShirt.getDescription());
        tvm.setPrice(tShirt.getPrice());
        tvm.setQuantity(tShirt.getQuantity());
       tvm.settShirtId(tShirt.getTShirtId());


        return tvm;
    }

    public List<TShirtViewModel> findAllTShirts() {
        List<TShirt> tShirtList = tShirtRepository.findAll();
        List<TShirtViewModel> tvmList = new ArrayList<>();
        for (TShirt tShirt : tShirtList) {
            TShirtViewModel tvm = buildTShirtViewModel(tShirt);
            tvmList.add(tvm);
        }
        return tvmList;
    }

    @Transactional
    public void updateTShirt(TShirtViewModel viewModel) {
        TShirt t = new TShirt();
        t.setSize(viewModel.getSize());
        t.setColor(viewModel.getColor());
        t.setDescription(viewModel.getDescription());
        t.setPrice(viewModel.getPrice());
        t.setQuantity(viewModel.getQuantity());
        t.setTShirtId(viewModel.gettShirtId());
        tShirtRepository.save(t);
    }

    @Transactional
    public void removeTshirt(Integer id) {

        tShirtRepository.deleteById(id);

    }

    public List<TShirtViewModel> findTShirtByColor(String color){
        List<TShirtViewModel> returnEmptyList = new ArrayList<>();
        List<TShirt> findTshirtByColor = tShirtRepository.findTShirtByColor(color);

        for(TShirt tshirt : findTshirtByColor){
            returnEmptyList.add(buildTShirtViewModel(tshirt));
        }
        return returnEmptyList;
    }

    public List<TShirtViewModel> findTShirtBySize(String size){ //findConsoleByManufacturer returns list of consols
        List<TShirtViewModel> returnEmptyList = new ArrayList<>();
        List<TShirt> findTshirtBySize = tShirtRepository.findTShirtBySize(size);

        for(TShirt tshirt : findTshirtBySize){
            returnEmptyList.add(buildTShirtViewModel(tshirt));
        }
        return returnEmptyList;
    }



//Console
@Transactional
public ConsoleViewModel saveConsole(ConsoleViewModel viewModel) {

    if (viewModel == null) {
        throw new IllegalArgumentException("invalid empty");
    }

    Console c = new Console();

    c.setManufacturer(viewModel.getConsoleManufacturer());
    c.setModel(viewModel.getConsoleModel());
    c.setPrice(viewModel.getConsolePrice());
    c.setQuantity(viewModel.getConsoleQuantity());
    c.setProcessor(viewModel.getConsoleProcessor());
    c.setMemoryAmount(viewModel.getConsoleMemory());


    c = consoleRepository.save(c);
    viewModel.setConsoleId(c.getConsoleId());
    return viewModel;
}

    public ConsoleViewModel findConsoleById(int id) {
        Optional<Console> console = consoleRepository.findById(id);
        return console.isPresent() ? buildConsoleViewModel(console.get()) : null;
    }
    private ConsoleViewModel buildConsoleViewModel(Console console) {

        ConsoleViewModel cvm = new ConsoleViewModel();
        cvm.setConsoleId(console.getConsoleId());
        cvm.setConsoleManufacturer(console.getManufacturer());
        cvm.setConsoleModel(console.getModel());
        cvm.setConsolePrice(console.getPrice());
        cvm.setConsoleQuantity(console.getQuantity());
        cvm.setConsoleProcessor(console.getProcessor());
        cvm.setConsoleMemory(console.getMemoryAmount());

        return cvm;
    }

public List<ConsoleViewModel> findAllByConsoleManufacturer(String manufacturer){ //findConsoleByManufacturer returns list of consols
        List<ConsoleViewModel> returnEmptyList = new ArrayList<>();
     List<Console> findManufacturer = consoleRepository.findAllByManufacturer(manufacturer);

     for(Console console : findManufacturer){
         returnEmptyList.add(buildConsoleViewModel(console)) ;
     }
     return returnEmptyList;
}
    public List<ConsoleViewModel> findAllConsoles() {
        List<Console> consoleList = consoleRepository.findAll();
        List<ConsoleViewModel> cvmList = new ArrayList<>();

        for (Console console : consoleList) {
            ConsoleViewModel cvm = buildConsoleViewModel(console);
            cvmList.add(cvm);
        }
        return cvmList;
    }

    @Transactional
    public void updateConsole(ConsoleViewModel viewModel) {

        Console c = new Console();

        c.setManufacturer(viewModel.getConsoleManufacturer());
        c.setModel(viewModel.getConsoleModel());
        c.setPrice(viewModel.getConsolePrice());
        c.setQuantity(viewModel.getConsoleQuantity());
        c.setProcessor(viewModel.getConsoleProcessor());
        c.setMemoryAmount(viewModel.getConsoleMemory());
        c.setConsoleId(viewModel.getConsoleId());


        consoleRepository.save(c);

    }

    @Transactional
    public void removeConsole(Integer id) {

        consoleRepository.deleteById(id);

    }


//Invoice

    @Transactional
    private InvoiceViewModel buildInvoiceViewModel(Invoice invoice) {

        InvoiceViewModel ivm = new InvoiceViewModel();
        ivm.setName(invoice.getName());
        ivm.setStreet(invoice.getStreet());
        ivm.setCity(invoice.getCity());
        ivm.setState(invoice.getState());
        ivm.setZipcode(invoice.getZipcode());
        ivm.setUnitPrice(invoice.getUnitPrice());
        ivm.setSubtotal(invoice.getSubtotal());
        ivm.setItemType(invoice.getItemType());
        ivm.setTax(invoice.getTax());
        ivm.setProcessingFee(invoice.getProcessingFee());
        ivm.setTotal(invoice.getTotal());
        ivm.setInvoiceId(invoice.getInvoiceId());
        ivm.setQuantity(invoice.getQuantity());
        ivm.setItemId(invoice.getItemId());


    return ivm;
    }

    public InvoiceViewModel findInvoiceById(int id) {

        // Get the invoice object first
        Optional<Invoice> invoice = invoiceRepository.findById(id);

        return invoice.isPresent() ? buildInvoiceViewModel(invoice.get()) : null;
    }

    public List<InvoiceViewModel> findAllInvoices() {

        List<Invoice> invoiceList = invoiceRepository.findAll();

        List<InvoiceViewModel> ivmList = new ArrayList<>();

        for (Invoice invoice : invoiceList) {
            InvoiceViewModel ivm = buildInvoiceViewModel(invoice);
            ivmList.add(ivm);
        }

        return ivmList;
    }

    @Transactional
    public void updateInvoice(InvoiceViewModel viewmodel) {

        // Update the game information
        Invoice i = new Invoice();
        i.setName(viewmodel.getName());
        i.setCity(viewmodel.getCity());
        i.setState(viewmodel.getState());
        i.setStreet(viewmodel.getStreet());
        i.setZipcode(viewmodel.getZipcode());
        i.setQuantity(viewmodel.getQuantity());
        i.setSubtotal(viewmodel.getSubtotal());
        i.setItemType(viewmodel.getItemType());
        i.setUnitPrice(viewmodel.getUnitPrice());
        i.setTax(viewmodel.getTax());
        i.setProcessingFee(viewmodel.getProcessingFee());
        i.setTotal(viewmodel.getTotal());
        i.setInvoiceId(viewmodel.getInvoiceId());
        i.setItemId(viewmodel.getItemId());
//        viewmodel.setInvoiceId(i.getInvoiceId());
//        viewmodel.setItemId(i.getItemId());

        invoiceRepository.save(i);

    }

    @Transactional
    public void removeInvoice(Integer id) {

        invoiceRepository.deleteById(id);

    }

    @Transactional
    public InvoiceViewModel saveInvoice(InvoiceViewModel viewmodel) {
        // name
        //street
        //city
        //state
        //zip
        //item type
        // itemId
        //quantity

        if (viewmodel == null) {
            throw new IllegalArgumentException("invalid empty");
        }

        Invoice i = new Invoice();
        i.setName(viewmodel.getName());
        i.setStreet(viewmodel.getStreet());
        i.setCity(viewmodel.getCity());
        i.setState(viewmodel.getState());
        i.setZipcode(viewmodel.getZipcode());
        i.setItemType(viewmodel.getItemType());
        i.setQuantity(viewmodel.getQuantity());



        i.setSubtotal(viewmodel.getSubtotal());
       // i.setTax(viewmodel.getTax());
        i.setProcessingFee(viewmodel.getProcessingFee());
        i.setTotal(viewmodel.getTotal());

        //viewmodel.setInvoiceId(i.getInvoiceId());


//This is the section used to set the price
        if (viewmodel.getItemType().equals("Games")) {

            Game game = null;
            Optional<Game> findGame = gameRepository.findById(viewmodel.getItemId());

            if (findGame.isPresent()) {
                game = findGame.get();

            } else {
                throw new NotFoundException("item does not exist");
            }
             // if statement to check that quantity is avialable - not available throw exception
               i.setUnitPrice(viewmodel.getUnitPrice());
            if (game.getQuantity() == viewmodel.getQuantity()) {
                throw new NotFoundException("item quantity mismatch");

            } viewmodel.setUnitPrice(game.getPrice());
            i.setUnitPrice(game.getPrice());
        } else if (viewmodel.getItemType().equals("Consoles")) {

            Console console = null;
            Optional<Console> findConsole = consoleRepository.findById(viewmodel.getItemId());

            if (findConsole.isPresent()) {
                console = findConsole.get();
            } else {
                throw new NotFoundException("item does not exist");
            }
            if (console.getQuantity() < viewmodel.getQuantity()) {
                throw new NotFoundException("item quantity mismatch");

            } viewmodel.setUnitPrice(console.getPrice());

              i.setUnitPrice(viewmodel.getUnitPrice());
        }else if (viewmodel.getItemType().equals("T-Shirts")) {

                TShirt tShirt = null;
                Optional<TShirt> findTShirt = tShirtRepository.findById(viewmodel.getItemId());

                if (findTShirt.isPresent()) {
                    tShirt = findTShirt.get();
                } else {
                    throw new NotFoundException("item does not exist");
                }
                if (tShirt.getQuantity() < viewmodel.getQuantity()) {
                    throw new NotFoundException("item quantity mismatch");
                }
                viewmodel.setUnitPrice(tShirt.getPrice());
                i.setUnitPrice(viewmodel.getUnitPrice());
            }

        //calculate and set subtotal
        //quantity * unitprice = subtotal
        //set subtotal on the invoice
        i.setSubtotal(i.getUnitPrice() * i.getQuantity());

        double taxRate = taxesRepository.findById(i.getState()).get().getTaxRate();
        //get tax calc tax and set tax (taxes repo)
        //tax = subtotal * taxrate
        double tax = i.getSubtotal() * taxRate;
        //set tax on invoice
        i.setTax(tax);

        //calc processing fee
        double processingFee = processingFeeRepository.findById(i.getItemType()).get().getFee();
        i.setProcessingFee(processingFee);
        //total = subtotal + tax + fee
        double total = i.getSubtotal() + i.getTax() + i.getProcessingFee();
        i.setTotal(total);

        i = invoiceRepository.save(i);
         viewmodel.setInvoiceId(i.getInvoiceId());
        return buildInvoiceViewModel(i);// returning view model
    }


}





