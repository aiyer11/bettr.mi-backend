package com.arjun.fitnessapp.Workout;

import com.arjun.fitnessapp.Exercise.Exercise;
import com.arjun.fitnessapp.Exercise.ExerciseRepository;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class WorkoutServiceTest {
    private WorkoutService workoutService;
    private WorkoutRepository workoutRepository;
    private ExerciseRepository exerciseRepository;

    private JSONObject workoutJson;

    @BeforeEach
    void setUp() throws IOException, ParseException {
        this.workoutService = new WorkoutService(this.workoutRepository,this.exerciseRepository);
        FileReader fileReader = new FileReader("./src/test/resources/Workout/workoutServiceTest.json");
        JSONParser parser = new JSONParser();
        this.workoutJson = (JSONObject) parser.parse(fileReader);
    }

    @Test
    public void createWorkoutTest() throws Exception {
        Workout workout = workoutService.createWorkout(workoutJson);
        List<Exercise> exerciseList = new ArrayList<>();
        Exercise exercise = new Exercise("Bench Press", 3,5,215.0);
        exerciseList.add(exercise);
        Exercise exercise1 = new Exercise("Squat", 3,5,315.0);
        exerciseList.add(exercise1);

        assertEquals(workout.getName(),"Strength Workout A","Expecting workout name to match");
        assertEquals(workout.getWorkoutType().getType(),WorkoutType.STRENGTH.getType(), "Expecting workout type to match");
        assertEquals(workout.getExerciseList(), exerciseList, "Expecting exercise list to match");
        assertEquals(workout.getDuration(),60,"Expecting duration to match");

    }
}
