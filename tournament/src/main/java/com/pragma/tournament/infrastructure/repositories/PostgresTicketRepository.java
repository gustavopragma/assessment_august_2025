package com.pragma.tournament.infrastructure.repositories;

import com.pragma.tournament.infrastructure.entities.TicketEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PostgresTicketRepository extends JpaRepository<TicketEntity, String> {
    List<TicketEntity> findByTypeAndTournamentId(String type, String tournamentId);
}