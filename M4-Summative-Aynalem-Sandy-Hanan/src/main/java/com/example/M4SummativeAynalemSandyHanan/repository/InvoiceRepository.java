package com.example.M4SummativeAynalemSandyHanan.repository;
import com.example.M4SummativeAynalemSandyHanan.model.Invoice;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface InvoiceRepository extends JpaRepository<Invoice, Integer> {

}
