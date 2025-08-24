package com.pragma.tournament.application.usecases;

import com.pragma.tournament.domain.exceptions.AlreadyExistsException;
import com.pragma.tournament.domain.exceptions.NotFoundException;
import com.pragma.tournament.domain.models.Streaming;
import com.pragma.tournament.domain.repositories.StreamingRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class StreamingUseCasesTests {

    private Streaming streaming;

    @Mock
    private StreamingRepository streamingRepository;

    @InjectMocks
    private StreamingUseCases streamingUseCases;

    @BeforeEach
    public void setUp() {
        streaming = new Streaming();
        streaming.setName("Streaming 1");
        streaming.setPlatform("Twitch");
        streaming.setUrl("http://twitch.com");
        streaming.setId("1234");
    }

    @Test
    public void createStreamingTest() {
        doNothing().when(streamingRepository).createStreaming(streaming);
        streamingUseCases.createStreaming(streaming);
        verify(streamingRepository, times(1)).createStreaming(streaming);
    }

    @Test
    public void createStreamingAlreadyExistsTest() {
        when(streamingRepository.getStreamingById(streaming.getId())).thenReturn(Optional.of(streaming));
        Assertions.assertThrows(AlreadyExistsException.class, () -> {
            streamingUseCases.createStreaming(streaming);
        });
        verify(streamingRepository, times(1)).getStreamingById(streaming.getId());
    }

    @Test
    public void getStreamingByIdNotFoundTest() {
        when(streamingRepository.getStreamingById(streaming.getId())).thenReturn(Optional.empty());
        Assertions.assertThrows(NotFoundException.class, () -> {
            streamingUseCases.getStreamingById(streaming.getId());
        });
        verify(streamingRepository, times(1)).getStreamingById(streaming.getId());
    }

    @Test
    public void getStreamingByIdTest() {
        when(streamingRepository.getStreamingById(streaming.getId())).thenReturn(Optional.of(streaming));
        streamingUseCases.getStreamingById(streaming.getId());
        verify(streamingRepository, times(1)).getStreamingById(streaming.getId());
    }
}