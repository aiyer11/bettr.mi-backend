package com.arjun.fitnessapp.model;


import lombok.Getter;

@Getter
public enum WorkoutType {
    CARDIO("Cardio"),
    STRENGTH("Strength");

    private final String type;

    WorkoutType(String type){
        this.type = type;
    }

}
