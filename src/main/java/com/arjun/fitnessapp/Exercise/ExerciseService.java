package com.arjun.fitnessapp.Exercise;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClient;

@Service
public class ExerciseService {

    @Value("exercise.api.base.url")
    private String baseUrl;

    @Value("exercise.api.key")
    private String apiKey;

    private final RestClient restClient;

    public ExerciseService(RestClient.Builder restClientBuilder) {
        this.restClient = restClientBuilder.baseUrl(baseUrl).build();
    }

    public Exercise getExerciseByName(String name){
       return this.restClient.get()
                .uri("/name?={name}",name)
                .header("X-Api-Key",this.apiKey)
                .accept(MediaType.APPLICATION_JSON)
                .retrieve().body(Exercise.class);
    }
}
