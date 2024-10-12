package com.arjun.fitnessapp.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.HashMap;

@Getter
@Setter
@NoArgsConstructor
@Entity
public class Food {
    @Column(name="food_name")
    private String name;

    @Column(name="serving_size")
    private ServingSize servingSize;

    @Column(name="meal")
    private MealType mealType;

    @Column(name="calories")
    private double calories;

    @Column(name="carbs")
    private double carbs;

    @Column(name = "protein")
    private double protein;

    @Column(name="fats")
    private double fats;

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private HashMap<String,Double> macros;

    public Food(String name, ServingSize servingSize, MealType mealType, double calories, double carbs, double protein, double fats)
    {
        this.name = name;
        this.servingSize = servingSize;
        this.mealType = mealType;
        this.calories = calories;
        this.carbs = carbs;
        this.protein = protein;
        this.fats = fats;
        this.macros = new HashMap<>();
    }

}
