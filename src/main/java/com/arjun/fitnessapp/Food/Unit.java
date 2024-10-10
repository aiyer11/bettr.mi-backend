package com.arjun.fitnessapp.Food;

import lombok.Getter;

@Getter
public enum Unit {
    GRAMS("g"),
    KILOGRAMS("kg"),
    OUNCES("oz"),
    CUPS("cups"),
    POUNDS("lbs"),
    TABLESPOON("tbps"),
    TEASPOON("tsp");

    private final String unit;

    Unit(String unit) {
        this.unit = unit;
    }
}
