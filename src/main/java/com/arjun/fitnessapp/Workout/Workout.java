package com.arjun.fitnessapp.Workout;

import com.arjun.fitnessapp.Exercise.Exercise;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import java.util.List;

@Entity
@NoArgsConstructor
@Setter
@Getter
public class Workout {

    @Column(name="exercises")
    @OneToMany
    private List<Exercise> exerciseList;
    @Id
    private Long id;

}
