package com.example.M4SummativeAynalemSandyHanan.repository;

import com.example.M4SummativeAynalemSandyHanan.model.Game;
import com.example.M4SummativeAynalemSandyHanan.model.TShirt;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TShirtRepository extends JpaRepository<TShirt, Integer> {
    List<TShirt> findTShirtByColor(String color);
    List<TShirt> findTShirtBySize(String size);
}
