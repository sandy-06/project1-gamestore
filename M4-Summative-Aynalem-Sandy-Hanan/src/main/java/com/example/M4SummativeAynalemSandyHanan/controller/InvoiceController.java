package com.example.M4SummativeAynalemSandyHanan.controller;
import com.example.M4SummativeAynalemSandyHanan.model.Invoice;
import com.example.M4SummativeAynalemSandyHanan.repository.InvoiceRepository;
import com.example.M4SummativeAynalemSandyHanan.service.ServiceLayer;
import com.example.M4SummativeAynalemSandyHanan.viewmodel.GameViewModel;
import com.example.M4SummativeAynalemSandyHanan.viewmodel.InvoiceViewModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class InvoiceController {
    @Autowired
    ServiceLayer serviceLayer;

    @RequestMapping(value = "/invoice", method = RequestMethod.POST)
    @ResponseStatus(HttpStatus.CREATED)
    public InvoiceViewModel addInvoice(@RequestBody InvoiceViewModel invoiceViewModel) {
        return serviceLayer.saveInvoice(invoiceViewModel);
    }

    @RequestMapping(value = "/invoice", method = RequestMethod.GET)
    @ResponseStatus(HttpStatus.OK)
    public List<InvoiceViewModel> getAllInvoices() {
        return serviceLayer.findAllInvoices();
    }

    @RequestMapping(value = "/invoice/{id}", method = RequestMethod.GET)
    @ResponseStatus(HttpStatus.OK)
    public InvoiceViewModel getInvoiceById(@PathVariable int id) {
        return serviceLayer.findInvoiceById(id);
    }


    @RequestMapping(value = "/invoice/{id}", method = RequestMethod.PUT)
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void updateInvoice(@PathVariable int id,@RequestBody InvoiceViewModel viewModel) {
        if (viewModel.getInvoiceId() == null) {
            viewModel.setInvoiceId(id);
        } else if (viewModel.getInvoiceId() != id) {
            throw new IllegalArgumentException("Ids don't match.");
        }
        serviceLayer.updateInvoice(viewModel);
    }

    @RequestMapping(value="/invoice/{id}", method=RequestMethod.DELETE)
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteInvoice(@PathVariable Integer id) {
        serviceLayer.removeInvoice(id);
    }
}

