package com.pragma.tournament.domain.repositories;

import com.pragma.tournament.domain.models.Tournament;

import java.util.Optional;

public interface TournamentRepository {
    String createTournament(Tournament tournament);
    Optional<Tournament> getTournamentById(String id);
}