package com.arjun.fitnessapp.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@Entity
public class Meal {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name="ingredients_list") @OneToMany
    private List<Food> ingredients;

    @Column(name="meal_type")
    private MealType mealType;

    @Column(name="meal_name")
    private String name;
    @Column(name="servings")
    private double servings;
    @Column(name="total_calories")
    private double totalCalories;
    @Column(name="total_carbs")
    private double totalCarbs;
    @Column(name="total_fats")
    private double totalFats;
    @Column(name="total_protein")
    private double totalProtein;

    public void calculateMacros(){
        for(Food food : ingredients){
            this.totalCalories += food.getCalories();
            this.totalCarbs += food.getCarbs();
            this.totalFats += food.getFats();
            this.totalProtein += food.getProtein();
        }
    }

    public void addFood(Food food){
        this.ingredients.add(food);
    }
}
