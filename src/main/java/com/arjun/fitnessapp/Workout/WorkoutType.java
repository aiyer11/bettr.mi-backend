package com.arjun.fitnessapp.Workout;


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
