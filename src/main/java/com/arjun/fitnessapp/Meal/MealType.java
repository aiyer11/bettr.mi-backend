package com.arjun.fitnessapp.Meal;

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
}
