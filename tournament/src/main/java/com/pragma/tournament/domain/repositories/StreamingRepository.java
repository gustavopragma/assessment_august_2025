package com.pragma.tournament.domain.repositories;

import com.pragma.tournament.domain.models.Streaming;

import java.util.List;
import java.util.Optional;

public interface StreamingRepository {
    void createStreaming(Streaming streaming);
    Optional<Streaming> getStreamingById(String id);
}