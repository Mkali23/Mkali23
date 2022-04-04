package com.example.smartfridge.services;

import com.example.smartfridge.models.Food;

import java.util.List;

public interface FoodService { //zavola metodu v repository, robit v kombinaci interface a trieda

    List<Food> getAllFood();
    void decrementAmount(Integer id);
    void save(Food food);
    List<Food> getFoodOfSimilarType(Food food);
}
