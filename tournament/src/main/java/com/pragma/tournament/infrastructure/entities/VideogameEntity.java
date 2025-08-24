package com.pragma.tournament.infrastructure.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity(name = "Videogame")
public class VideogameEntity {
    @Id
    private String id;
    private String name;
    private String genre;
    private Integer numberPlayers;
}