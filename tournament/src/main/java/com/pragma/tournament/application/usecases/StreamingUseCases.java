package com.pragma.tournament.application.usecases;

import com.pragma.tournament.domain.exceptions.AlreadyExistsException;
import com.pragma.tournament.domain.exceptions.NotFoundException;
import com.pragma.tournament.domain.models.Streaming;
import com.pragma.tournament.domain.repositories.StreamingRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class StreamingUseCases {
    private final StreamingRepository streamingRepository;

    public StreamingUseCases(StreamingRepository streamingRepository) {
        this.streamingRepository = streamingRepository;
    }

    public void createStreaming(Streaming streaming) {
        Optional<Streaming> previousStreaming = streamingRepository.getStreamingById(streaming.getId());
        if(previousStreaming.isPresent()) throw new AlreadyExistsException("Streaming with ID " + streaming.getId() + " already exists");
        streamingRepository.createStreaming(streaming);
    }

    public Streaming getStreamingById(String id) {
        Optional<Streaming> streaming = streamingRepository.getStreamingById(id);
        if(streaming.isPresent()) return streaming.get();
        else throw new NotFoundException("Streaming not found");
    }
}