package com.arjun.fitnessapp.service;

import com.arjun.fitnessapp.model.Exercise;
import com.arjun.fitnessapp.model.Workout;
import com.arjun.fitnessapp.repository.WorkoutRepository;
import com.arjun.fitnessapp.model.WorkoutType;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class WorkoutServiceImpl implements WorkoutService {

    @Autowired
    private final WorkoutRepository workoutRepository;

    @Autowired
    private final ExerciseService exerciseService;

    @Autowired
    public WorkoutServiceImpl(WorkoutRepository workoutRepository, ExerciseService exerciseService) {
        this.workoutRepository = workoutRepository;
        this.exerciseService = exerciseService;
    }

    public Workout createWorkout(JSONObject workoutJson) throws Exception {

        Workout workout = new Workout();
        workout.setName(workoutJson.get("name").toString());

        if(workoutJson.get("workoutType").equals(WorkoutType.CARDIO.getType()))
        {
            workout.setWorkoutType(WorkoutType.CARDIO);
        }
        else if(workoutJson.get("workoutType").equals(WorkoutType.STRENGTH.getType()))
        {
            workout.setWorkoutType(WorkoutType.STRENGTH);
            JSONArray exerciseListJson = (JSONArray) workoutJson.get("exercises");

            for(Object exerciseObj: exerciseListJson)
            {
                JSONObject exerciseJson = (JSONObject) exerciseObj;
                Exercise exercise = exerciseService.createExercise(exerciseJson);
                workout.addExercise(exercise);
            }
        }
        else{
            throw new Exception("Unsupported Workout Type");
        }

        workout.setDuration(Integer.parseInt(workoutJson.get("duration").toString()));
        // TODO: Get database set up to save workout information
        //workoutRepository.save(workout);
        return workout;
    }
}
