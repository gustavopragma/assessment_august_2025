package com.pragma.tournament.infrastructure.repositories;

import com.pragma.tournament.infrastructure.entities.TournamentEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PostgresTournamentRepository extends JpaRepository<TournamentEntity, String> {
}