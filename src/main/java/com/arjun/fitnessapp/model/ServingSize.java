package com.arjun.fitnessapp.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class ServingSize {
    private double servings;
    private Unit servingUnit;

    @Override
    public String toString() {
        return servings + " " + servingUnit.getUnit();
    }
}
