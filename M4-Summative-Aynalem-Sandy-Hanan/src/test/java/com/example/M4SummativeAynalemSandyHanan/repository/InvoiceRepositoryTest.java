package com.example.M4SummativeAynalemSandyHanan.repository;

import com.example.M4SummativeAynalemSandyHanan.model.Game;
import com.example.M4SummativeAynalemSandyHanan.model.Invoice;
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
public class InvoiceRepositoryTest {

    @Autowired
    InvoiceRepository invoiceRepository;

    @Before
    public void setUp() throws Exception {
        invoiceRepository.deleteAll();

    }

    @Test
    public void addGetDeleteInvoice(){

        Invoice invoice = new Invoice();
        invoice.setItemId(2);
        invoice.setName("Hanan");
        invoice.setStreet("21 wonderland");
        invoice.setCity("Richmond");
        invoice.setState("VA");
        invoice.setZipcode("49922");
        invoice.setUnitPrice(500);
        invoice.setItemType("console");
        invoice.setQuantity(1);


        invoice = invoiceRepository.save(invoice);

        Optional<Invoice> invoice1 = invoiceRepository.findById(invoice.getInvoiceId());

        assertEquals(invoice1.get(), invoice);

        invoice1 = invoiceRepository.findById(invoice.getInvoiceId());

        assertTrue(invoice1.isPresent());

    }

    @Test
    public void updateInvoice(){

        Invoice invoice = new Invoice();
        invoice.setItemId(2);
        invoice.setName("Hanan");
        invoice.setStreet("21 wonderland");
        invoice.setCity("Richmond");
        invoice.setState("VA");
        invoice.setZipcode("49922");
        invoice.setUnitPrice(500);
        invoice.setItemType("console");
        invoice.setQuantity(1);


        invoice = invoiceRepository.save(invoice);

        invoice.setName("Hanan");
        invoice.setStreet("21 wonderland");
        invoice.setCity("Richmond");
        invoice.setState("VA");
        invoice.setZipcode("49922");
        invoice.setUnitPrice(20);
        invoice.setItemType("tshirt");
        invoice.setQuantity(2);


        invoiceRepository.save(invoice);

        Optional<Invoice> invoice1 = invoiceRepository.findById(invoice.getInvoiceId());
        assertEquals(invoice1.get(), invoice);

    }

    @Test
    public void getAllInvoice(){
        Invoice invoice = new Invoice();
        invoice.setName("Hanan");
        invoice.setStreet("21 wonderland");
        invoice.setCity("Richmond");
        invoice.setState("VA");
        invoice.setZipcode("49922");
        invoice.setUnitPrice(500);
        invoice.setItemType("console");
        invoice.setQuantity(1);
        invoice.getProcessingFee();


        invoice = invoiceRepository.save(invoice);

        invoice = new Invoice();
        invoice.setItemId(2);
        invoice.setName("Hanan");
        invoice.setStreet("21 wonderland");
        invoice.setCity("Richmond");
        invoice.setState("VA");
        invoice.setZipcode("49922");
        invoice.setUnitPrice(500);
        invoice.setItemType("console");
        invoice.setQuantity(1);
        invoice.getProcessingFee();


        invoice = invoiceRepository.save(invoice);

        List<Invoice> iList = invoiceRepository.findAll();
        assertEquals(iList.size(), 2);


    }
}
