package com.arjun.fitnessapp.service;

import com.arjun.fitnessapp.model.*;
import com.arjun.fitnessapp.repository.MealRepository;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MealServiceImpl implements MealService {
    @Autowired
    private final MealRepository mealRepository;

    @Autowired
    private final FoodServiceImpl foodService;


    public MealServiceImpl(MealRepository mealRepository, FoodServiceImpl foodService) {
        this.mealRepository = mealRepository;
        this.foodService = foodService;
    }

    public Meal createMeal(JSONObject mealJson) {
        Meal meal = new Meal();
        meal.setName(mealJson.get("name").toString());
        meal.setMealType(MealType.findByMeal(mealJson.get("mealType").toString()));
        JSONArray foods = (JSONArray) mealJson.get("foods");
        for (Object o : foods) {
            JSONObject foodJson = (JSONObject) o;
            Food food = foodService.createFood(foodJson);
            meal.addFood(food);
            meal.calculateMacros();
        }
        Meal savedMeal = mealRepository.save(meal);
        return mealRepository.save(meal);
    }

}
