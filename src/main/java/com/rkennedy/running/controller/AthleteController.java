package com.rkennedy.running.controller;

import com.rkennedy.running.persistance.entities.Athlete;
import com.rkennedy.running.persistance.respository.AthleteRepository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/athletes")
public class AthleteController {

    @Autowired
    AthleteRepository athleteRepository;

    /**
     * Returns the list of all the athlete Entities.
     *
     * @return List<Athletes>
     */
    @GetMapping("/")
    public ResponseEntity<List<Athlete>> getAthletes() {
        return ResponseEntity.ok(athleteRepository.findAll());
    }
}
