package com.pragma.tournament.application.usecases;

import com.pragma.tournament.domain.exceptions.AlreadyExistsException;
import com.pragma.tournament.domain.exceptions.NotFoundException;
import com.pragma.tournament.domain.models.Notification;
import com.pragma.tournament.domain.models.Ticket;
import com.pragma.tournament.domain.models.Tournament;
import com.pragma.tournament.domain.repositories.TicketRepository;
import com.pragma.tournament.domain.repositories.TournamentRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;

@Service
public class TicketUseCases {
    private final TicketRepository ticketRepository;
    private final TournamentRepository tournamentRepository;
    private final NotificationUseCases notificationUseCases;

    public TicketUseCases(TicketRepository ticketRepository, TournamentRepository tournamentRepository, NotificationUseCases notificationUseCases) {
        this.ticketRepository = ticketRepository;
        this.tournamentRepository = tournamentRepository;
        this.notificationUseCases = notificationUseCases;
    }

    public String createTicket(Ticket ticket) {
        Optional<Ticket> previousTicket = ticketRepository.getTicketById(ticket.getId());
        if(previousTicket.isPresent()) throw new AlreadyExistsException("Ticket with ID " + ticket.getId() + " already exists");

        Optional<Tournament> tournament = tournamentRepository.getTournamentById(ticket.getTournament());
        if(tournament.isEmpty()) throw new NotFoundException("Tournament not found");
        String ticketId = ticketRepository.createTicket(ticket);

        Notification notification = new Notification();
        notification.setId(UUID.randomUUID().toString());
        notification.setMessage("TICKET CREATED WITH ID " + ticketId + " FOR TOURNAMENT WITH ID " + ticket.getTournament() + " TO USER WITH ID " + ticket.getUser() + " AND TYPE " + ticket.getType());
        notification.setType("TICKET_CREATED_" + ticket.getType());
        notification.setTournament(ticket.getTournament());
        notificationUseCases.sendNotification(notification);

        return ticketId;
    }

    public Ticket getTicketById(String id) {
        Optional<Ticket> ticket = ticketRepository.getTicketById(id);
        if(ticket.isPresent()) return ticket.get();
        else throw new NotFoundException("Ticket not found");
    }

    public Integer getTotalSpectatorsByTournamentId(String tournamentId) {
        Optional<Tournament> tournament = tournamentRepository.getTournamentById(tournamentId);
        if(tournament.isEmpty()) throw new NotFoundException("Tournament not found");
        return ticketRepository.getTotalSpectatorsByTournamentId(tournamentId);
    }

    public Integer getTotalParticipantsByTournamentId(String tournamentId) {
        Optional<Tournament> tournament = tournamentRepository.getTournamentById(tournamentId);
        if(tournament.isEmpty()) throw new NotFoundException("Tournament not found");
        return ticketRepository.getTotalParticipantsByTournamentId(tournamentId);
    }
}