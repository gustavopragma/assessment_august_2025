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
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class TournamentUseCases {
    private final TournamentRepository tournamentRepository;
    private final VideogameRepository videogameRepository;
    private final CategoryRepository categoryRepository;
    private final StreamingRepository streamingRepository;

    public TournamentUseCases(TournamentRepository tournamentRepository, VideogameRepository videogameRepository, CategoryRepository categoryRepository, StreamingRepository streamingRepository) {
        this.tournamentRepository = tournamentRepository;
        this.videogameRepository = videogameRepository;
        this.categoryRepository = categoryRepository;
        this.streamingRepository = streamingRepository;
    }

    public String createTournament(Tournament tournament) {
        Optional<Tournament> previousTournament = tournamentRepository.getTournamentById(tournament.getId());
        if(previousTournament.isPresent()) throw new AlreadyExistsException("Tournament with ID " + tournament.getId() + " already exists");

        Optional<Videogame> videogame = videogameRepository.getVideogameById(tournament.getVideogame());
        if(videogame.isEmpty()) throw new NotFoundException("Videogame not found");

        Optional<Streaming> streaming = streamingRepository.getStreamingById(tournament.getStreaming());
        if(streaming.isEmpty()) throw new NotFoundException("Streaming not found");

        Optional<Category> category = categoryRepository.getCategoryById(tournament.getCategory());
        if(category.isEmpty()) throw new NotFoundException("Category not found");

        return tournamentRepository.createTournament(tournament);
    }

    public Tournament getTournamentById(String id) {
        Optional<Tournament> tournament = tournamentRepository.getTournamentById(id);
        if(tournament.isPresent()) return tournament.get();
        else throw new NotFoundException("Tournament not found");
    }
}