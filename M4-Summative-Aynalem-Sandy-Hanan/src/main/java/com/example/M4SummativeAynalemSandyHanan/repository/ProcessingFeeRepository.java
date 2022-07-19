package com.example.M4SummativeAynalemSandyHanan.repository;

import com.example.M4SummativeAynalemSandyHanan.model.Game;
import com.example.M4SummativeAynalemSandyHanan.model.ProcessingFee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProcessingFeeRepository extends JpaRepository<ProcessingFee, String> {
}
