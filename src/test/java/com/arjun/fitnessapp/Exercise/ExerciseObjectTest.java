package com.arjun.fitnessapp.Exercise;

import com.arjun.fitnessapp.model.Exercise;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class ExerciseObjectTest {

    private static final String EXERCISE_NAME = "Bicep Curls";
    private static final int SETS = 3;
    private static final int REPS = 10;
    private static final double WEIGHT = 105.5;

    private Exercise exercise;
    private Exercise exercise2;

    private Exercise exerciseDiffName;
    private Exercise exerciseDiffReps;
    private Exercise exerciseDiffWeight;
    private Exercise exerciseDiffSets;

    @BeforeEach
    void setUp() {
        this.exercise = new Exercise(EXERCISE_NAME, SETS, REPS,WEIGHT);
        this.exercise2 = new Exercise(EXERCISE_NAME, SETS, REPS,WEIGHT);
        this.exerciseDiffName = new Exercise(EXERCISE_NAME+"A", SETS, REPS, WEIGHT);
        this.exerciseDiffReps = new Exercise(EXERCISE_NAME, SETS, REPS+1, WEIGHT);
        this.exerciseDiffSets = new Exercise(EXERCISE_NAME, SETS+1, REPS, WEIGHT);
        this.exerciseDiffWeight = new Exercise(EXERCISE_NAME, SETS, REPS, WEIGHT+10);
    }

    @Test
    public void testConstructorGettersSetters() {
        Exercise exercise = new Exercise();
        exercise.setName(EXERCISE_NAME);
        exercise.setSets(SETS);
        exercise.setRepetitions(REPS);
        exercise.setWeight(WEIGHT);
        validateObj(exercise);
    }

    @Test
    public void testEquals() {
        assertEquals(this.exercise, this.exercise2, "Expecting an object to be equal to an identical object");
    }

    @Test
    public void testEqualsNegative(){
        assertNotNull(this.exercise,"Expecting object to not be equal to null");
        assertNotEquals(this.exercise,this.exerciseDiffName, "Expecting object to not be equal if the name fields are different");
        assertNotEquals(this.exercise,this.exerciseDiffReps, "Expecting object to not be equal if the rep fields are different");
        assertNotEquals(this.exercise,this.exerciseDiffSets, "Expecting object to not be equal if the set fields are different");
        assertNotEquals(this.exercise,this.exerciseDiffWeight, "Expecting object to not be equal if the weight fields are different");
    }


    // Helper
    private static void validateObj(Exercise exercise) {
        assertEquals(EXERCISE_NAME, exercise.getName(), "Expecting the name field to have the correct value");
        assertEquals(SETS, exercise.getSets(), "Expecting the sets field to have the correct value");
        assertEquals(REPS, exercise.getRepetitions(), "Expecting the repetitions field to have the correct value");
        assertEquals(WEIGHT, exercise.getWeight(), "Expecting the weight field to have the correct value");
    }

}
