package com.pragma.tournament.infrastructure.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity(name = "Category")
public class CategoryEntity {
    @Id
    private String id;
    private String name;
    private Integer maxParticipants;
    private Integer maxSpectators;
    private Boolean free;
}