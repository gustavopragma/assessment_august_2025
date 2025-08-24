package com.pragma.tournament.infrastructure.mappers;

import com.pragma.tournament.domain.models.Streaming;
import com.pragma.tournament.infrastructure.entities.StreamingEntity;
import org.springframework.stereotype.Component;

@Component
public class StreamingMapper implements Mapper<StreamingEntity, Streaming>{
    @Override
    public StreamingEntity toEntity(Streaming model) {
        return StreamingEntity.builder()
                .id(model.getId())
                .name(model.getName())
                .url(model.getUrl())
                .platform(model.getPlatform())
                .build();
    }

    @Override
    public Streaming toModel(StreamingEntity entity) {
        Streaming streaming = new Streaming();
        streaming.setId(entity.getId());
        streaming.setName(entity.getName());
        streaming.setUrl(entity.getUrl());
        streaming.setPlatform(entity.getPlatform());
        return streaming;
    }
}