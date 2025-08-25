package com.pragma.tournament.infrastructure.controllers;

import com.pragma.tournament.application.usecases.TicketUseCases;
import com.pragma.tournament.domain.models.Ticket;
import com.pragma.tournament.infrastructure.dtos.TotalParticipantsResponseDTO;
import com.pragma.tournament.infrastructure.dtos.TotalSpectatorsResponseDTO;
import org.springframework.security.core.Authentication;
import org.springframework.security.oauth2.jwt.Jwt;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/api/v1/tickets")
public class TicketController {
    private final TicketUseCases ticketUseCases;

    public TicketController(TicketUseCases ticketUseCases) {
        this.ticketUseCases = ticketUseCases;
    }

    @PostMapping("")
    public String createTicket(@RequestBody Ticket ticket, Authentication authentication) {
        Jwt jwt = (Jwt) authentication.getPrincipal();
        ticket.setUser(jwt.getSubject());
        return ticketUseCases.createTicket(ticket);
    }

    @GetMapping("/{id}")
    public Ticket getTicketById(@PathVariable(value = "id") String id) {
        return ticketUseCases.getTicketById(id);
    }

    @GetMapping("/totalSpectators/{tournamentId}")
    public TotalSpectatorsResponseDTO getTotalSpectators(@PathVariable(value = "tournamentId") String tournamentId) {
        Integer totalSpectators = ticketUseCases.getTotalSpectatorsByTournamentId(tournamentId);
        return TotalSpectatorsResponseDTO.builder()
                .totalSpectators(totalSpectators)
                .build();
    }

    @GetMapping("/totalParticipants/{tournamentId}")
    public TotalParticipantsResponseDTO getTotalParticipants(@PathVariable(value = "tournamentId") String tournamentId) {
        Integer totalParticipants = ticketUseCases.getTotalParticipantsByTournamentId(tournamentId);
        return TotalParticipantsResponseDTO.builder()
                .totalParticipants(totalParticipants)
                .build();
    }
}