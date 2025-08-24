package com.pragma.tournament.infrastructure.repositories;

import com.pragma.tournament.infrastructure.entities.StreamingEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PostgresStreamingRepository extends JpaRepository<StreamingEntity, String> {
}