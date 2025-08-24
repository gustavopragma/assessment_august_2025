package com.pragma.tournament.infrastructure.controllers;

import com.pragma.tournament.application.usecases.StreamingUseCases;
import com.pragma.tournament.domain.models.Streaming;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping( value = "/api/v1/streamings")
public class StreamingController {
    private final StreamingUseCases streamingUseCases;

    public StreamingController(StreamingUseCases streamingUseCases) {
        this.streamingUseCases = streamingUseCases;
    }

    @PostMapping(value = "")
    @ResponseStatus(HttpStatus.CREATED)
    public void createStreaming(@RequestBody Streaming streaming) {
        streamingUseCases.createStreaming(streaming);
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Streaming getStreamingById(@PathVariable(value = "id") String id) {
        return streamingUseCases.getStreamingById(id);
    }
}