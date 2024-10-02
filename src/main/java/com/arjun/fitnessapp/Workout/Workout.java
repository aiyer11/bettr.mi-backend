package com.arjun.fitnessapp.Workout;

import com.arjun.fitnessapp.Exercise.Exercise;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Entity
@Setter
@Getter
public class Workout {

    @Column(name="exercises") @OneToMany
    private List<Exercise> exerciseList;

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "workout_name")
    private String name;

    @Column(name = "workout_type")
    private WorkoutType workoutType;

    @Column(name = "workout_duration")
    private int duration;

    public Workout(){
        this.exerciseList = new ArrayList<>();
    }

    public Workout(List<Exercise> exerciseList)
    {
        this.exerciseList = exerciseList;
    }

    public Workout(List<Exercise> exerciseList, String name, WorkoutType workoutType, int duration)
    {
        this.exerciseList = exerciseList;
        this.name = name;
        this.workoutType = workoutType;
        this.duration = duration;
    }

    public void addExercise(Exercise exercise)
    {
        this.exerciseList.add(exercise);
    }

    @Override
    public boolean equals(Object o)
    {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Workout workout = (Workout) o;
        return this.exerciseList.equals(workout.exerciseList) && this.name.equals(workout.name) &&
                this.workoutType.getType().equals(workout.workoutType.getType()) &&
                this.duration == workout.duration;
    }

}
