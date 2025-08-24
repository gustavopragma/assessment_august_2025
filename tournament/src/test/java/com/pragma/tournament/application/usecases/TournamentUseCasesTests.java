package com.pragma.tournament.application.usecases;

import com.pragma.tournament.domain.exceptions.AlreadyExistsException;
import com.pragma.tournament.domain.exceptions.NotFoundException;
import com.pragma.tournament.domain.models.Category;
import com.pragma.tournament.domain.models.Streaming;
import com.pragma.tournament.domain.models.Tournament;
import com.pragma.tournament.domain.models.Videogame;
import com.pragma.tournament.domain.repositories.CategoryRepository;
import com.pragma.tournament.domain.repositories.StreamingRepository;
import com.pragma.tournament.domain.repositories.TournamentRepository;
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

@ExtendWith(MockitoExtension.class)
public class TournamentUseCasesTests {

    private Tournament tournament;

    @Mock
    private TournamentRepository tournamentRepository;

    @Mock
    private VideogameRepository videogameRepository;

    @Mock
    private CategoryRepository categoryRepository;

    @Mock
    private StreamingRepository streamingRepository;


    @InjectMocks
    private TournamentUseCases tournamentUseCases;

    @BeforeEach
    public void setUp() {
        tournament = new Tournament();
        tournament.setOwner("1234");
        tournament.setVideogame("1234");
        tournament.setStreaming("1234");
        tournament.setCategory("1234");
        tournament.setId("1234");
    }

    @Test
    public void createTournamentNotFoundVideogame() {
        when(videogameRepository.getVideogameById(tournament.getVideogame())).thenReturn(Optional.empty());
        Assertions.assertThrows(NotFoundException.class, () -> {
            tournamentUseCases.createTournament(tournament);
        });
        verify(videogameRepository, times(1)).getVideogameById(tournament.getVideogame());
    }

    @Test
    public void createTournamentNotFoundStreaming() {
        when(videogameRepository.getVideogameById(tournament.getVideogame())).thenReturn(Optional.of(mock(Videogame.class)));
        when(streamingRepository.getStreamingById(tournament.getStreaming())).thenReturn(Optional.empty());
        Assertions.assertThrows(NotFoundException.class, () -> {
            tournamentUseCases.createTournament(tournament);
        });
        verify(videogameRepository, times(1)).getVideogameById(tournament.getVideogame());
        verify(streamingRepository, times(1)).getStreamingById(tournament.getStreaming());
    }

    @Test
    public void createTournamentNotFoundCategory() {
        when(videogameRepository.getVideogameById(tournament.getVideogame())).thenReturn(Optional.of(mock(Videogame.class)));
        when(streamingRepository.getStreamingById(tournament.getStreaming())).thenReturn(Optional.of(mock(Streaming.class)));
        when(categoryRepository.getCategoryById(tournament.getCategory())).thenReturn(Optional.empty());
        Assertions.assertThrows(NotFoundException.class, () -> {
            tournamentUseCases.createTournament(tournament);
        });
        verify(videogameRepository, times(1)).getVideogameById(tournament.getVideogame());
        verify(streamingRepository, times(1)).getStreamingById(tournament.getStreaming());
        verify(categoryRepository, times(1)).getCategoryById(tournament.getCategory());
    }

    @Test
    public void createTournament() {
        when(videogameRepository.getVideogameById(tournament.getVideogame())).thenReturn(Optional.of(mock(Videogame.class)));
        when(streamingRepository.getStreamingById(tournament.getStreaming())).thenReturn(Optional.of(mock(Streaming.class)));
        when(categoryRepository.getCategoryById(tournament.getCategory())).thenReturn(Optional.of(mock(Category.class)));
        tournamentUseCases.createTournament(tournament);
        verify(videogameRepository, times(1)).getVideogameById(tournament.getVideogame());
        verify(streamingRepository, times(1)).getStreamingById(tournament.getStreaming());
        verify(categoryRepository, times(1)).getCategoryById(tournament.getCategory());
        verify(tournamentRepository, times(1)).createTournament(tournament);
    }

    @Test
    public void createTournamentAlreadyExistsTest() {
        when(tournamentRepository.getTournamentById(tournament.getId())).thenReturn(Optional.of(tournament));
        Assertions.assertThrows(AlreadyExistsException.class, () -> {
            tournamentUseCases.createTournament(tournament);
        });
        verify(tournamentRepository, times(1)).getTournamentById(tournament.getId());
    }

    @Test
    public void getTournamentByIdNotFoundTest() {
        when(tournamentRepository.getTournamentById(tournament.getId())).thenReturn(Optional.empty());
        Assertions.assertThrows(NotFoundException.class, () -> {
            tournamentUseCases.getTournamentById(tournament.getId());
        });
        verify(tournamentRepository, times(1)).getTournamentById(tournament.getId());
    }

    @Test
    public void getTournamentByIdTest() {
        when(tournamentRepository.getTournamentById(tournament.getId())).thenReturn(Optional.of(tournament));
        tournamentUseCases.getTournamentById(tournament.getId());
        verify(tournamentRepository, times(1)).getTournamentById(tournament.getId());
    }
}