package com.pragma.tournament.infrastructure.repositories;

import com.pragma.tournament.domain.models.Ticket;
import com.pragma.tournament.domain.repositories.TicketRepository;
import com.pragma.tournament.infrastructure.entities.TicketEntity;
import com.pragma.tournament.infrastructure.mappers.TicketMapper;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class TicketRepositoryImpl implements TicketRepository {
    private final TicketMapper ticketMapper;
    private final PostgresTicketRepository postgresTicketRepository;
    private final PostgresTournamentRepository postgresTournamentRepository;

    public TicketRepositoryImpl(TicketMapper ticketMapper, PostgresTicketRepository postgresTicketRepository, PostgresTournamentRepository postgresTournamentRepository) {
        this.ticketMapper = ticketMapper;
        this.postgresTicketRepository = postgresTicketRepository;
        this.postgresTournamentRepository = postgresTournamentRepository;
    }

    @Override
    public String createTicket(Ticket ticket) {
        TicketEntity ticketEntity = ticketMapper.toEntity(ticket);
        ticketEntity.setTournament(postgresTournamentRepository.getReferenceById(ticket.getTournament()));

        TicketEntity savedTicket = postgresTicketRepository.save(ticketEntity);
        return savedTicket.getId();
    }

    @Override
    public Optional<Ticket> getTicketById(String id) {
        Optional<TicketEntity> ticketEntity = postgresTicketRepository.findById(id);
        return ticketEntity.map(ticketMapper::toModel);
    }

    @Override
    public Integer getTotalSpectatorsByTournamentId(String tournamentId) {
        List<TicketEntity> ticketEntities = postgresTicketRepository.findByTypeAndTournamentId("SPECTATOR", tournamentId);
        return ticketEntities.size();
    }

    @Override
    public Integer getTotalParticipantsByTournamentId(String tournamentId) {
        List<TicketEntity> ticketEntities = postgresTicketRepository.findByTypeAndTournamentId("PARTICIPANT", tournamentId);
        return ticketEntities.size();
    }
}