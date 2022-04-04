package com.example.smartfridge.repository;

import com.example.smartfridge.models.Food;
import com.example.smartfridge.models.FoodType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

//comunicates with database - Food Table
@Repository //umozni aplikacii injektovat (autowiring), samotna nema ucinok na to ci sa pripajam k databaze
public interface FoodRepository extends JpaRepository<Food, Integer> { //interface extendnuty ma silu realne manipulovat s datami
                                //food -model s ktorym manipuluje, Integer -datovy typ
    //custom query
    List<Food> findAllByType(FoodType type);
}
