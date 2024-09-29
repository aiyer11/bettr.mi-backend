package com.arjun.fitnessapp.Exercise;


import com.fasterxml.jackson.annotation.JsonProperty;
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

    @Column(name = "exercise_name") @JsonProperty("name")
    private String name;

    @Column(name = "exercise_type") @JsonProperty("type")
    private String type;

    @Column(name = "muscle") @JsonProperty("muscle")
    private String muscle;

    private int sets;

    private int repetitions;

    public Exercise(String name,String type,String muscle) {
        this.name = name;
        this.type = type;
        this.muscle = muscle;
    }


}
