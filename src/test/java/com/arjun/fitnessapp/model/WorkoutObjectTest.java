package com.arjun.fitnessapp.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

public class WorkoutObjectTest {

    private static final List<Exercise> EXERCISE_LIST = Collections.singletonList(new Exercise("Bicep Curl",3,10,105.5));

    private static final String NAME = "workout";

    private static final WorkoutType WORKOUT_TYPE = WorkoutType.STRENGTH;


    private static int DURATION;

    private Workout workout;
    private Workout workout1;
    private Workout workoutDiffName;
    private Workout workoutDiffType;

    @BeforeEach
    void setUp() {
        this.workout = new Workout(EXERCISE_LIST,NAME,WORKOUT_TYPE,DURATION);
        this.workout1 = new Workout(EXERCISE_LIST,NAME,WORKOUT_TYPE,DURATION);
        this.workoutDiffName = new Workout(EXERCISE_LIST,NAME+"A",WorkoutType.STRENGTH,DURATION);
        this.workoutDiffType = new Workout(EXERCISE_LIST,NAME,WorkoutType.CARDIO,DURATION);
    }

    @Test
    public void testConstructorGettersSetters(){
        Workout workout = new Workout();
        workout.setName(NAME);
        workout.setWorkoutType(WORKOUT_TYPE);
        workout.setDuration(DURATION);
        workout.setExerciseList(EXERCISE_LIST);
        validateObj(workout);
    }

    @Test
    public void testEquals(){
        assertEquals(workout,workout1, "Expecting identical workout objects to be equal");
    }

    @Test
    public void testEqualsNegative(){
        assertNotEquals(workout,workoutDiffName, "Expecting workouts with different names to not be equal");
        assertNotEquals(workout,workoutDiffType, "Expecting workouts with different types to not be equal");
    }


    // Helper
    private static void validateObj(Workout workout){
        assertEquals(NAME, workout.getName(),"Expecting the workout object to have the correct value");
        assertEquals(WORKOUT_TYPE.getType(), workout.getWorkoutType().getType(), "Expecting the workout object to have the correct value");
        assertEquals(EXERCISE_LIST,workout.getExerciseList(),"Expecting the workout object to have the correct value");
        assertEquals(DURATION,workout.getDuration(),"Expecting the workout object to have the correct value");
    }
}
