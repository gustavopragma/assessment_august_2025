package com.pragma.tournament.infrastructure.entities;

import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity(name = "Tournament")
public class TournamentEntity {
    @Id
    private String id;
    private String name;
    @OneToOne
    private StreamingEntity streaming;
    @ManyToOne
    private CategoryEntity category;
    @ManyToOne
    private VideogameEntity videogame;
    private String owner;
}