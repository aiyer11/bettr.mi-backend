package com.arjun.fitnessapp.service;

import com.arjun.fitnessapp.model.Exercise;
import com.arjun.fitnessapp.repository.ExerciseRepository;
import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ExerciseServiceImpl implements ExerciseService {

    @Autowired
    private final ExerciseRepository exerciseRepository;

    public ExerciseServiceImpl(ExerciseRepository exerciseRepository) {
        this.exerciseRepository = exerciseRepository;
    }

    public Exercise createExercise(JSONObject exerciseJson){
        Exercise exercise = new Exercise(exerciseJson.get("name").toString(),
                Integer.parseInt(exerciseJson.get("sets").toString()),
                Integer.parseInt(exerciseJson.get("reps").toString()),
                Double.parseDouble(exerciseJson.get("weight").toString()));

        // TODO: Get database set up to save exercise information
        //exerciseRepository.save(exercise);
        return exercise;
    }
}
