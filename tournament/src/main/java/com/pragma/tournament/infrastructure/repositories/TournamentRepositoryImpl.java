package com.pragma.tournament.infrastructure.repositories;

import com.pragma.tournament.domain.models.Tournament;
import com.pragma.tournament.domain.repositories.TournamentRepository;
import com.pragma.tournament.infrastructure.entities.TournamentEntity;
import com.pragma.tournament.infrastructure.mappers.TournamentMapper;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public class TournamentRepositoryImpl implements TournamentRepository {
    private final TournamentMapper tournamentMapper;
    private final PostgresTournamentRepository postgresTournamentRepository;
    private final PostgresCategoryRepository postgresCategoryRepository;
    private final PostgresStreamingRepository postgresStreamingRepository;
    private final PostgresVideogameRepository postgresVideogameRepository;

    public TournamentRepositoryImpl(TournamentMapper tournamentMapper, PostgresTournamentRepository postgresTournamentRepository, PostgresCategoryRepository postgresCategoryRepository, PostgresStreamingRepository postgresStreamingRepository, PostgresVideogameRepository postgresVideogameRepository) {
        this.tournamentMapper = tournamentMapper;
        this.postgresTournamentRepository = postgresTournamentRepository;
        this.postgresCategoryRepository = postgresCategoryRepository;
        this.postgresStreamingRepository = postgresStreamingRepository;
        this.postgresVideogameRepository = postgresVideogameRepository;
    }

    @Override
    public String createTournament(Tournament tournament) {
        TournamentEntity tournamentEntity = tournamentMapper.toEntity(tournament);
        tournamentEntity.setCategory(postgresCategoryRepository.getReferenceById(tournament.getCategory()));
        tournamentEntity.setVideogame(postgresVideogameRepository.getReferenceById(tournament.getVideogame()));
        tournamentEntity.setStreaming(postgresStreamingRepository.getReferenceById(tournament.getStreaming()));

        TournamentEntity savedTournament = postgresTournamentRepository.save(tournamentEntity);
        return savedTournament.getId();
    }

    @Override
    public Optional<Tournament> getTournamentById(String id) {
        return postgresTournamentRepository.findById(id).map(tournamentMapper::toModel);
    }
}