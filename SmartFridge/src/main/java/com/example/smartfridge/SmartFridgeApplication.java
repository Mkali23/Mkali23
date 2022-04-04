package com.example.smartfridge;

import com.example.smartfridge.models.Food;
import com.example.smartfridge.models.FoodType;
import com.example.smartfridge.repository.FoodRepository;
import com.example.smartfridge.repository.FoodTypeRepository;
import com.example.smartfridge.services.FoodService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

@SpringBootApplication
public class SmartFridgeApplication implements CommandLineRunner {

    public static void main(String[] args) {
        SpringApplication.run(SmartFridgeApplication.class, args);
    }

    //depend Inj.--->Vkládání závislostí je v objektově orientovaném programování technika
    // pro vkládání závislostí mezi jednotlivými komponentami programu tak,
    // aby jedna komponenta mohla používat druhou,
    // aniž by na ni měla v době sestavování programu referenci.
    FoodRepository foodRepository;
    FoodTypeRepository foodTypeRepository;
    FoodService foodService;

    @Autowired
    public SmartFridgeApplication(FoodRepository foodRepository, FoodTypeRepository foodTypeRepository, FoodService foodService) {
        this.foodRepository = foodRepository;
        this.foodTypeRepository = foodTypeRepository;
        this.foodService = foodService;
    }

    @Override
    public void run(String... args) throws Exception {

        FoodType mp = new FoodType("milk produce");
        FoodType ab = new FoodType("alcoholic beverage");

        List<Food> myFoods = List.of(

                new Food(3, "Mlieko", mp),
                new Food(12, "Plzen", ab),
                new Food(2, "Parenicka",mp));
        //save(!) data first on which we depend; CascadeType.ALL - if used will help with saving
        foodTypeRepository.save(mp);
        foodTypeRepository.save(ab);
        //save(!)
        foodRepository.saveAll(myFoods);


    }
}
