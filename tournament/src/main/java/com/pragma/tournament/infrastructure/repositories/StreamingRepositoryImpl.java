package com.pragma.tournament.infrastructure.repositories;

import com.pragma.tournament.domain.models.Streaming;
import com.pragma.tournament.domain.repositories.StreamingRepository;
import com.pragma.tournament.infrastructure.entities.StreamingEntity;
import com.pragma.tournament.infrastructure.mappers.StreamingMapper;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public class StreamingRepositoryImpl implements StreamingRepository {
    private final StreamingMapper streamingMapper;
    private final PostgresStreamingRepository postgresStreamingRepository;

    public StreamingRepositoryImpl(StreamingMapper streamingMapper, PostgresStreamingRepository postgresStreamingRepository) {
        this.streamingMapper = streamingMapper;
        this.postgresStreamingRepository = postgresStreamingRepository;
    }

    @Override
    public void createStreaming(Streaming streaming) {
        StreamingEntity streamingEntity = streamingMapper.toEntity(streaming);
        postgresStreamingRepository.save(streamingEntity);
    }

    @Override
    public Optional<Streaming> getStreamingById(String id) {
        Optional<StreamingEntity> streamingEntity = postgresStreamingRepository.findById(id);
        return streamingEntity.map(streamingMapper::toModel);
    }
}