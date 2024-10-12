package com.arjun.fitnessapp.model;

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

    public static Unit findByUnit(String unit) {
        for(Unit u: Unit.values()) {
            if(u.getUnit().equals(unit)) {
                return u;
            }
        }
        return null;
    }
}
