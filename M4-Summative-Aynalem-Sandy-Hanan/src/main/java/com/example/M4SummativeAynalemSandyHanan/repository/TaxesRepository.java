package com.example.M4SummativeAynalemSandyHanan.repository;

import com.example.M4SummativeAynalemSandyHanan.model.Game;
import com.example.M4SummativeAynalemSandyHanan.model.Taxes;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TaxesRepository extends JpaRepository<Taxes,String> {
}
