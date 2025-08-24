package com.pragma.tournament.application.usecases;

import com.pragma.tournament.domain.exceptions.AlreadyExistsException;
import com.pragma.tournament.domain.exceptions.NotFoundException;
import com.pragma.tournament.domain.models.Notification;
import com.pragma.tournament.domain.models.Ticket;
import com.pragma.tournament.domain.models.Tournament;
import com.pragma.tournament.domain.repositories.TicketRepository;
import com.pragma.tournament.domain.repositories.TournamentRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class TicketUseCasesTests {

    private Ticket ticket;

    @Mock
    private TicketRepository ticketRepository;

    @Mock
    private TournamentRepository tournamentRepository;

    @Mock
    private NotificationUseCases notificationUseCases;

    @InjectMocks
    private TicketUseCases ticketUseCases;

    @BeforeEach
    public void setUp() {
        ticket = new Ticket();
        ticket.setUser("1234");
        ticket.setTournament("1234");
        ticket.setType("TYPE 1");
        ticket.setSaleComission(50);
        ticket.setStage("STAGE 1");
        ticket.setPrice(200.0);
        ticket.setActive(true);
        ticket.setId("1234");
    }

    @Test
    public void createTicketNotFoundTournamentTest() {
        when(tournamentRepository.getTournamentById(ticket.getTournament())).thenReturn(Optional.empty());
        Assertions.assertThrows(NotFoundException.class, () -> {
            ticketUseCases.createTicket(ticket);
        });
        verify(tournamentRepository, times(1)).getTournamentById(ticket.getTournament());
    }

    @Test
    public void createTicketTest() {
        when(tournamentRepository.getTournamentById(ticket.getTournament())).thenReturn(Optional.of(mock(Tournament.class)));
        ticketUseCases.createTicket(ticket);
        verify(tournamentRepository, times(1)).getTournamentById(ticket.getTournament());
        verify(ticketRepository, times(1)).createTicket(ticket);
        verify(notificationUseCases, times(1)).sendNotification(any(Notification.class));
    }

    @Test
    public void createTicketAlreadyExistsTest() {
        when(ticketRepository.getTicketById(ticket.getId())).thenReturn(Optional.of(ticket));
        Assertions.assertThrows(AlreadyExistsException.class, () -> {
            ticketUseCases.createTicket(ticket);
        });
        verify(ticketRepository, times(1)).getTicketById(ticket.getId());
    }

    @Test
    public void getTicketByIdNotFoundTest() {
        when(ticketRepository.getTicketById(ticket.getId())).thenReturn(Optional.empty());
        Assertions.assertThrows(NotFoundException.class, () -> {
            ticketUseCases.getTicketById(ticket.getId());
        });
        verify(ticketRepository, times(1)).getTicketById(ticket.getId());
    }

    @Test
    public void getTicketByIdTest() {
        when(ticketRepository.getTicketById(ticket.getId())).thenReturn(Optional.of(ticket));
        ticketUseCases.getTicketById(ticket.getId());
        verify(ticketRepository, times(1)).getTicketById(ticket.getId());
    }

    @Test
    public void getTotalSpectatorsByTournamentIdNotFoundTournamentTest() {
        when(tournamentRepository.getTournamentById(ticket.getTournament())).thenReturn(Optional.empty());
        Assertions.assertThrows(NotFoundException.class, () -> {
            ticketUseCases.getTotalSpectatorsByTournamentId(ticket.getTournament());
        });
        verify(tournamentRepository, times(1)).getTournamentById(ticket.getTournament());
    }

    @Test
    public void getTotalParticipantsByTournamentIdNotFoundTournamentTest() {
        when(tournamentRepository.getTournamentById(ticket.getTournament())).thenReturn(Optional.empty());
        Assertions.assertThrows(NotFoundException.class, () -> {
            ticketUseCases.getTotalParticipantsByTournamentId(ticket.getTournament());
        });
        verify(tournamentRepository, times(1)).getTournamentById(ticket.getTournament());
    }

    @Test
    public void getTotalSpectatorsByTournamentIdTest() {
        when(tournamentRepository.getTournamentById(ticket.getTournament())).thenReturn(Optional.of(mock(Tournament.class)));
        ticketUseCases.getTotalSpectatorsByTournamentId(ticket.getTournament());
        verify(tournamentRepository, times(1)).getTournamentById(ticket.getTournament());
        verify(ticketRepository, times(1)).getTotalSpectatorsByTournamentId(ticket.getTournament());
    }

    @Test
    public void getTotalParticipantsByTournamentIdTest() {
        when(tournamentRepository.getTournamentById(ticket.getTournament())).thenReturn(Optional.of(mock(Tournament.class)));
        ticketUseCases.getTotalParticipantsByTournamentId(ticket.getTournament());
        verify(tournamentRepository, times(1)).getTournamentById(ticket.getTournament());
        verify(ticketRepository, times(1)).getTotalParticipantsByTournamentId(ticket.getTournament());
    }
}