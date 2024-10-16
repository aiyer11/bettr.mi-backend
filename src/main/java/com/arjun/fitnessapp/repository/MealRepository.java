package com.arjun.fitnessapp.repository;

import com.arjun.fitnessapp.model.Meal;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MealRepository extends JpaRepository<Meal, Long> {

}
