package com.arjun.fitnessapp.service;

import com.arjun.fitnessapp.model.Exercise;
import org.json.simple.JSONObject;

public interface ExerciseService {
    Exercise createExercise(JSONObject exerciseJson);
}
