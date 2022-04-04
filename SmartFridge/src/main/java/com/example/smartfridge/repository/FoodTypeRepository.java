package com.example.smartfridge.repository;

import com.example.smartfridge.models.FoodType;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FoodTypeRepository extends JpaRepository<FoodType, Integer> {
}
