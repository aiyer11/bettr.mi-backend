package com.arjun.fitnessapp.Exercise;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Setter
@Getter
@Entity
public class Exercise {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "exercise_name")
    private String name;

    @Column(name = "sets")
    private int sets;

    @Column(name = "reps")
    private int repetitions;

    @Column(name = "weight")
    private double weight;

    public Exercise(String name, int sets, int repetitions, double weight) {
        this.name = name;
        this.sets = sets;
        this.repetitions = repetitions;
        this.weight = weight;
    }

    @Override
    public boolean equals(Object o) {
        if(this == o) return true;
        if(o == null || getClass() != o.getClass()) return false;
        Exercise exercise = (Exercise) o;
        return this.name.equals(exercise.name) &&
                this.sets == exercise.sets &&
                this.weight == exercise.weight &&
                this.repetitions == exercise.repetitions;
    }
}
