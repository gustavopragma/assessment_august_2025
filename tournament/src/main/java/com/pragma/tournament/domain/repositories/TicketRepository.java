package com.pragma.tournament.domain.repositories;

import com.pragma.tournament.domain.models.Ticket;

import java.util.Optional;

public interface TicketRepository {
    String createTicket(Ticket ticket);
    Optional<Ticket> getTicketById(String id);
    Integer getTotalSpectatorsByTournamentId(String tournamentId);
    Integer getTotalParticipantsByTournamentId(String tournamentId);
}