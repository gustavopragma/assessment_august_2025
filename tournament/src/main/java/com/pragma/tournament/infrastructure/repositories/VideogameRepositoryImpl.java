package com.pragma.tournament.infrastructure.repositories;

import com.pragma.tournament.domain.models.Videogame;
import com.pragma.tournament.domain.repositories.VideogameRepository;
import com.pragma.tournament.infrastructure.entities.VideogameEntity;
import com.pragma.tournament.infrastructure.mappers.VideogameMapper;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public class VideogameRepositoryImpl implements VideogameRepository {
    private final PostgresVideogameRepository postgresVideogameRepository;
    private final VideogameMapper videogameMapper;

    public VideogameRepositoryImpl(PostgresVideogameRepository postgresVideogameRepository, VideogameMapper videogameMapper) {
        this.postgresVideogameRepository = postgresVideogameRepository;
        this.videogameMapper = videogameMapper;
    }

    @Override
    public void createVideogame(Videogame videogame) {
        VideogameEntity videogameEntity = videogameMapper.toEntity(videogame);
        postgresVideogameRepository.save(videogameEntity);
    }

    @Override
    public Optional<Videogame> getVideogameById(String id) {
        Optional<VideogameEntity> videogameEntity = postgresVideogameRepository.findById(id);
        return videogameEntity.map(videogameMapper::toModel);
    }
}