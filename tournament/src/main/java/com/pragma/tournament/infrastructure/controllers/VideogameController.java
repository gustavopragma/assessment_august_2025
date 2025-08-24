package com.pragma.tournament.infrastructure.controllers;

import com.pragma.tournament.application.usecases.VideogameUseCases;
import com.pragma.tournament.domain.models.Videogame;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping( value = "/api/v1/videogames")
public class VideogameController {
    private final VideogameUseCases videogameUseCases;

    public VideogameController(VideogameUseCases videogameUseCases) {
        this.videogameUseCases = videogameUseCases;
    }

    @PostMapping(value = "")
    @ResponseStatus(HttpStatus.CREATED)
    public void createVideogame(@RequestBody Videogame videogame) {
        videogameUseCases.createVideogame(videogame);
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Videogame getVideogameById(@PathVariable(value = "id") String videogameId) {
        return videogameUseCases.getVideogameById(videogameId);
    }
}