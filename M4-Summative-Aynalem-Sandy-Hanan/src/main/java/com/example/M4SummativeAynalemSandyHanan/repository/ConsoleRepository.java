package com.example.M4SummativeAynalemSandyHanan.repository;

import com.example.M4SummativeAynalemSandyHanan.model.Console;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Repository
public interface ConsoleRepository extends JpaRepository<Console, Integer> {

    List<Console> findAllByManufacturer(String consoleManufacturer);

}
