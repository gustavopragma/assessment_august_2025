package com.pragma.tournament.infrastructure.repositories;

import com.pragma.tournament.infrastructure.entities.VideogameEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PostgresVideogameRepository extends JpaRepository<VideogameEntity, String> {
}