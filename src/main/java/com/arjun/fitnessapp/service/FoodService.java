package com.arjun.fitnessapp.service;

import com.arjun.fitnessapp.model.Food;
import org.json.simple.JSONObject;

public interface FoodService {
    Food createFood(JSONObject foodJson);
}
