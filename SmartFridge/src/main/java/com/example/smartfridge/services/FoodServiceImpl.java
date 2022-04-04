package com.example.smartfridge.services;

import com.example.smartfridge.models.Food;
import com.example.smartfridge.repository.FoodRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service //info pre spring aby autowiroval hodnoty
public class FoodServiceImpl implements FoodService {

    private FoodRepository foodRepository; //property tohoto objektu

    @Autowired //iniciuje objekt foodRepository, spring to robi na pozadi
    public FoodServiceImpl(FoodRepository foodRepository) {
        this.foodRepository = foodRepository;
    }

    @Override
    public List<Food> getAllFood() {
        return this.foodRepository.findAll();
    }

    @Override
    public void decrementAmount(Integer id) {
        Optional<Food> food = foodRepository.findById(id);

        if (food.isPresent()) {
            Food realFood = food.get();

            if (realFood.getAmount() <= 0) {
                return;
            }
            realFood.decrementAmount();
            foodRepository.save(realFood);
        } else {
            throw new IllegalArgumentException();
        }
    }

    @Override
    public void save(Food food) {
        foodRepository.save(food);
    }

    public List<Food> getFoodOfSimilarType(Food food) {
        return foodRepository.findAllByType(food.getType());
    }

}
