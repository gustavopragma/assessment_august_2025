package com.pragma.tournament.infrastructure.controllers;

import com.pragma.tournament.application.usecases.TournamentUseCases;
import com.pragma.tournament.domain.models.Tournament;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping( value = "/api/v1/tournaments")
public class TournamentController {
    private final TournamentUseCases tournamentUseCases;

    public TournamentController(TournamentUseCases tournamentUseCases) {
        this.tournamentUseCases = tournamentUseCases;
    }

    @PostMapping(value = "")
    @ResponseStatus(HttpStatus.CREATED)
    public void createTournament(@RequestBody Tournament tournament) {
        tournamentUseCases.createTournament(tournament);
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Tournament getTournamentById(@PathVariable(value = "id") String id) {
        return tournamentUseCases.getTournamentById(id);
    }
}