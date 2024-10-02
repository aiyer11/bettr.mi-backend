package com.arjun.fitnessapp.Workout;

import com.arjun.fitnessapp.Exercise.Exercise;
import com.arjun.fitnessapp.Exercise.ExerciseRepository;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class WorkoutService {

    private final WorkoutRepository workoutRepository;
    private final ExerciseRepository exerciseRepository;

    @Autowired
    public WorkoutService(WorkoutRepository workoutRepository, ExerciseRepository exerciseRepository) {
        this.workoutRepository = workoutRepository;
        this.exerciseRepository = exerciseRepository;
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
                Exercise exercise = new Exercise(exerciseJson.get("name").toString(),
                        Integer.parseInt(exerciseJson.get("sets").toString()),
                        Integer.parseInt(exerciseJson.get("reps").toString()),
                        Double.parseDouble(exerciseJson.get("weight").toString()));
                // TODO: Get database set up to save exercise information
                //exerciseRepository.save(exercise);
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
