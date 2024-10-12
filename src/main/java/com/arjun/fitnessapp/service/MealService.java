package com.arjun.fitnessapp.service;

import com.arjun.fitnessapp.model.Food;
import com.arjun.fitnessapp.model.Meal;
import com.arjun.fitnessapp.model.ServingSize;
import com.arjun.fitnessapp.model.Unit;
import com.arjun.fitnessapp.repository.FoodRepository;
import com.arjun.fitnessapp.repository.MealRepository;
import com.fasterxml.jackson.databind.json.JsonMapper;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MealService {
    @Autowired
    private final MealRepository mealRepository;


    public MealService(MealRepository mealRepository) {
        this.mealRepository = mealRepository;
    }

    public Meal createMeal(JSONObject mealJson) {
        Meal meal = new Meal();
        meal.setName(mealJson.get("name").toString());
        JSONArray foods = (JSONArray) mealJson.get("foods");
        for(int i = 0; i < foods.size(); i++) {
            JSONObject food = (JSONObject) foods.get(i);
            Food foodObj = new Food();
            foodObj.setName(food.get("name").toString());
            String servingString = food.get("servingSize").toString();
            String[] servingSize = servingString.split(" ");
            foodObj.setServingSize(new ServingSize(Double.parseDouble(servingSize[0]), Unit.findByUnit(servingSize[1])));

        }
    }

}
