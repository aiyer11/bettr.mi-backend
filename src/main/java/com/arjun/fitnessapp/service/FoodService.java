package com.arjun.fitnessapp.service;

import com.arjun.fitnessapp.model.Food;
import com.arjun.fitnessapp.model.ServingSize;
import com.arjun.fitnessapp.model.Unit;
import com.arjun.fitnessapp.repository.FoodRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;

@Service
public class FoodService {
    @Autowired
    private final FoodRepository foodRepository;

    public FoodService(FoodRepository foodRepository) {
        this.foodRepository = foodRepository;
    }

    public HashMap<String,Double> retrieveMacros(String name, ServingSize servingSize) {
        String servingSizeString = servingSize.toString();
        HashMap<String,Double> macros = new HashMap<>();

        // Need to figure out how the food information will be stored
        Food food = foodRepository.findByName(name);

    }

    private double convertToGrams(ServingSize servingSize) {
        return switch (servingSize.getServingUnit()) {
            case GRAMS -> servingSize.getServings();
            case KILOGRAMS -> servingSize.getServings() / 1000;
            case OUNCES -> servingSize.getServings() / 28.35;
            case POUNDS -> servingSize.getServings() / 453.6;
            default -> -1;
        };
    }


}
