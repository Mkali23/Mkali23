package com.example.smartfridge.models;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;


@Entity
@Getter
@Setter
public class FoodType {
    //fields -----
    @Id
    @GeneratedValue
    private Integer id;

    private String foodName;

    //linking table - serves for mapping by "type"; List stores all avail. food
    //cascade = CascadeType.All - if used will help with saving

    @OneToMany(mappedBy = "type")
    List<Food> foods;

    //empty constructor
    public FoodType() {
    }
    //constructor
    public FoodType(String foodName) {
        this.foodName = foodName;
    }

    //method
    @Override
    public String toString() {
        return foodName;
    }

    //get & set (@ lombok)
}
