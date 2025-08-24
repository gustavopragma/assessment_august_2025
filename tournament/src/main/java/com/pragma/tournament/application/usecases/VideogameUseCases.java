package com.pragma.tournament.application.usecases;

import com.pragma.tournament.domain.exceptions.AlreadyExistsException;
import com.pragma.tournament.domain.exceptions.NotFoundException;
import com.pragma.tournament.domain.models.Videogame;
import com.pragma.tournament.domain.repositories.VideogameRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;
@Service
public class VideogameUseCases {
    private final VideogameRepository videogameRepository;

    public VideogameUseCases(VideogameRepository videogameRepository) {
        this.videogameRepository = videogameRepository;
    }

    public void createVideogame(Videogame videogame) {
        Optional<Videogame> previousVideogame = videogameRepository.getVideogameById(videogame.getId());
        if(previousVideogame.isPresent()) throw new AlreadyExistsException("Videogame with ID " + videogame.getId() + " already exists");
        videogameRepository.createVideogame(videogame);
    }

    public Videogame getVideogameById(String id) {
        Optional<Videogame> videogame = videogameRepository.getVideogameById(id);
        if(videogame.isPresent()) return videogame.get();
        else throw new NotFoundException("Videogame not found");
    }
}