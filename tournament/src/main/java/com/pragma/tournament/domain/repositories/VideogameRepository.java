
package com.pragma.tournament.domain.repositories;

import com.pragma.tournament.domain.models.Videogame;

import java.util.Optional;

public interface VideogameRepository {
    void createVideogame(Videogame videogame);
    Optional<Videogame> getVideogameById(String id);
}
