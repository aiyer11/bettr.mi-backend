package com.arjun.fitnessapp.Workout;

public enum WorkoutType {
    CARDIO("Cardio"),
    STRENGTH("Strength");

    private String type;

    WorkoutType(String type){
        this.type = type;
    }

    public String getType(){
        return type;
    }
}
