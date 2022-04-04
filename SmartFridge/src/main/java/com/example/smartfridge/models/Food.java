package com.example.smartfridge.models;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Date;

@Entity //oznamujem ze chcem aby bolo ulozene do databazy
@Getter //lombok
@Setter //lombok
public class Food {
    // field
    @Id //kazda trieda musi mat ID
    @GeneratedValue//(strategy = GenerationType.AUTO)  //hovori  databaze aby priradovala cisla novym polozkam (su 4 strategie)
    private Integer id;

    private Integer amount;

    private String name;

    //linking table - serves for mapping by "foodType type" ----
    @ManyToOne
    FoodType type;

    //empty constructor ----
    public Food() {
    }

    //constructor ----
    public Food(Integer amount, String name, FoodType type) {
        this.amount = amount;
        this.name = name;
        this.type = type;
    }

    //method; Decrements amount of this.food by "1" -----
    public void decrementAmount(){
        this.amount --;
    }

    @Override
    public String toString() {
        return this.name + ": " + this.amount ;
    }

    //get & set (lombok @)----
}
