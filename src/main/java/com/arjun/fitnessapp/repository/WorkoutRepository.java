package com.arjun.fitnessapp.repository;

import com.arjun.fitnessapp.model.Workout;
import com.arjun.fitnessapp.model.WorkoutType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface WorkoutRepository extends JpaRepository<Workout, Long> {

    Workout findByName(String name);

    List<Workout> findWorkoutsByType(WorkoutType type);
}
