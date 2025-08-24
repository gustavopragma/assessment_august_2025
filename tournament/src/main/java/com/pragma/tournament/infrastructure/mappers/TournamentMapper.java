package com.pragma.tournament.infrastructure.mappers;

import com.pragma.tournament.domain.models.Tournament;
import com.pragma.tournament.infrastructure.entities.TournamentEntity;
import org.springframework.stereotype.Component;

@Component
public class TournamentMapper implements Mapper<TournamentEntity, Tournament>{
    @Override
    public TournamentEntity toEntity(Tournament model) {
        return TournamentEntity.builder()
                .id(model.getId())
                .name(model.getName())
                .owner(model.getOwner())
                .build();
    }

    @Override
    public Tournament toModel(TournamentEntity entity) {
        Tournament tournament = new Tournament();
        tournament.setId(entity.getId());
        tournament.setName(entity.getName());
        tournament.setCategory(entity.getCategory().getId());
        tournament.setStreaming(entity.getStreaming().getId());
        tournament.setVideogame(entity.getVideogame().getId());
        tournament.setOwner(entity.getOwner());
        return tournament;
    }
}