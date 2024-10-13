package com.arjun.fitnessapp.service;

import com.arjun.fitnessapp.model.Workout;
import org.json.simple.JSONObject;

public interface WorkoutService {
    Workout createWorkout(JSONObject workoutJson) throws Exception;
}
