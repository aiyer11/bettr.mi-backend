package com.arjun.fitnessapp.Workout;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface WorkoutRepository extends JpaRepository<Workout, Long> {

    Workout findByName(String name);

    List<Workout> findWorkoutsByType(WorkoutType type);
}
