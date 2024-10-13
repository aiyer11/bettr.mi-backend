package com.arjun.fitnessapp.model;

import lombok.Getter;

@Getter
public enum MealType {
    BREAKFAST("Breakfast"),
    LUNCH("Lunch"),
    DINNER("Dinner"),
    SNACK("Snack");

    private final String meal;

    MealType(String meal)
    {
        this.meal = meal;
    }

    public static MealType findByMeal(String meal){
        for(MealType m: MealType.values()) {
            if(m.getMeal().equals(meal)) {
                return m;
            }
        }
        return null;
    }
}
