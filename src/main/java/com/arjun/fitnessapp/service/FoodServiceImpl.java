package com.arjun.fitnessapp.service;

import com.arjun.fitnessapp.model.Food;
import com.arjun.fitnessapp.model.ServingSize;
import com.arjun.fitnessapp.model.Unit;
import com.arjun.fitnessapp.repository.FoodRepository;
import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FoodServiceImpl implements FoodService{
    @Autowired
    private final FoodRepository foodRepository;

    public FoodServiceImpl(FoodRepository foodRepository) {
        this.foodRepository = foodRepository;
    }

    public Food createFood(JSONObject foodJson) {
        String servingSizeString = foodJson.get("servingSize").toString();
        String[] split = servingSizeString.split(" ");
        ServingSize servingSize = new ServingSize(Double.parseDouble(split[0]), Unit.findByUnit(split[1]));

        String name = foodJson.get("name").toString();
        double calories = Double.parseDouble(foodJson.get("calories").toString());
        double protein = Double.parseDouble(foodJson.get("protein").toString());
        double carbs = Double.parseDouble(foodJson.get("carbs").toString());
        double fats = Double.parseDouble(foodJson.get("fats").toString());

        Food food = new Food(name, servingSize, calories, protein, carbs, fats);

        //TODO: Create DB to store food information
        //foodRepository.save(food);

        return food;
    }


}
