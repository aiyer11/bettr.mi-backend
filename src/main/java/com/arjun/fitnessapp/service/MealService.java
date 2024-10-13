package com.arjun.fitnessapp.service;

import com.arjun.fitnessapp.model.Meal;
import org.json.simple.JSONObject;

public interface MealService {
    Meal createMeal(JSONObject mealJson);
}
