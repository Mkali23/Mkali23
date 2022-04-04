package com.example.smartfridge.controllers;

import com.example.smartfridge.models.Food;
import com.example.smartfridge.repository.FoodTypeRepository;
import com.example.smartfridge.services.FoodService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import static org.springframework.data.jpa.domain.AbstractPersistable_.id;

@Controller
public class WebController {

    //depend inj. for Service interface -----
    private FoodService foodService;
    private FoodTypeRepository foodTypeRepository;

    @Autowired
    public WebController(FoodService foodService, FoodTypeRepository foodTypeRepository) { //konstruktor

        this.foodService = foodService;
        this.foodTypeRepository = foodTypeRepository;
    }
    //Main view, "model" provides data to HTML-----
    @GetMapping("/") //defaultne stranka v prehliadaci posiela get request aby otvorila stranku
    public String showHomepage(Model model){ //String lebo chcem vratit nazov suboru, odkaz na nas model
        model.addAttribute("foods", this.foodService.getAllFood()); //data presunute z databazy do service do naseho view
        model.addAttribute("foodTypes", foodTypeRepository.findAll());
        return "index";
    }

    //decrements amount of the food -----
    @GetMapping("/decrement-amount/{id}")
    public String decrementFoodAmount(@PathVariable Integer id){ //adresa decrement-amount/1 ---path variable
        foodService.decrementAmount(id);                        //decrement-amount?id=1 ---request param zalezi v akej casti url ju chcem mat zadanu
        return "redirect:/"; //vrati nas naspat na stranku
    }
    //Form adds food, "model" provided by html form ----
    @PostMapping("/add-food")
    public String addNewFood(@ModelAttribute Food newFood){
        foodService.save(newFood);
        return "redirect:/";
    }
}
