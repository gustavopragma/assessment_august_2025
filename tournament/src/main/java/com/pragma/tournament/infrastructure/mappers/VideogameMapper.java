package com.pragma.tournament.infrastructure.mappers;

import com.pragma.tournament.domain.models.Videogame;
import com.pragma.tournament.infrastructure.entities.VideogameEntity;
import org.springframework.stereotype.Component;

@Component
public class VideogameMapper implements Mapper<VideogameEntity, Videogame> {
    public VideogameEntity toEntity(Videogame videogame) {
        return VideogameEntity.builder()
                .id(videogame.getId())
                .name(videogame.getName())
                .genre(videogame.getGenre())
                .numberPlayers(videogame.getNumberPlayers())
                .build();
    }

    public Videogame toModel(VideogameEntity videogameEntity) {
        Videogame videogame = new Videogame();
        videogame.setId(videogameEntity.getId());
        videogame.setName(videogameEntity.getName());
        videogame.setGenre(videogameEntity.getGenre());
        videogame.setNumberPlayers(videogameEntity.getNumberPlayers());
        return videogame;
    }
}