package com.pragma.tournament.application.usecases;

import com.pragma.tournament.domain.exceptions.AlreadyExistsException;
import com.pragma.tournament.domain.exceptions.NotFoundException;
import com.pragma.tournament.domain.models.Videogame;
import com.pragma.tournament.domain.repositories.VideogameRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static org.mockito.Mockito.*;
import static org.mockito.Mockito.times;

@ExtendWith(MockitoExtension.class)
public class VideogameUseCasesTests {

    private Videogame videogame;

    @Mock
    private VideogameRepository videogameRepository;

    @InjectMocks
    private VideogameUseCases videogameUseCases;

    @BeforeEach
    public void setUp() {
        videogame = new Videogame();
        videogame.setId("1234");
        videogame.setGenre("SHOOTER");
        videogame.setNumberPlayers(5);
        videogame.setName("VIDEOGAME 1");
    }

    @Test
    public void createVideogameTest() {
        doNothing().when(videogameRepository).createVideogame(videogame);
        videogameUseCases.createVideogame(videogame);
        verify(videogameRepository, times(1)).createVideogame(videogame);
    }

    @Test
    public void createVideogameAlreadyExistsTest() {
        when(videogameRepository.getVideogameById(videogame.getId())).thenReturn(Optional.of(videogame));
        Assertions.assertThrows(AlreadyExistsException.class, () -> {
            videogameUseCases.createVideogame(videogame);
        });
        verify(videogameRepository, times(1)).getVideogameById(videogame.getId());
        verify(videogameRepository, never()).createVideogame(any());
    }

    @Test
    public void getVideogameByIdNotFoundTest() {
        when(videogameRepository.getVideogameById(videogame.getId())).thenReturn(Optional.empty());
        Assertions.assertThrows(NotFoundException.class, () -> {
            videogameUseCases.getVideogameById(videogame.getId());
        });
        verify(videogameRepository, times(1)).getVideogameById(videogame.getId());
    }

    @Test
    public void getVideogameByIdTest() {
        when(videogameRepository.getVideogameById(videogame.getId())).thenReturn(Optional.of(videogame));
        videogameUseCases.getVideogameById(videogame.getId());
        verify(videogameRepository, times(1)).getVideogameById(videogame.getId());
    }
}