package com.arjun.fitnessapp.Exercise;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ExerciseRepository extends JpaRepository<Exercise, Long> {

    Exercise findExerciseByName(String name);

    List<Exercise> findExercisesByMuscle(String muscle);

    List<Exercise> findExercisesByType(String type);

    Exercise insertExercise(Exercise exercise);
}
