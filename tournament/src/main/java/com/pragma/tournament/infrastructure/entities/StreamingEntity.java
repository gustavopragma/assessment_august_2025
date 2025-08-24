package com.pragma.tournament.infrastructure.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity(name = "Streaming")
public class StreamingEntity {
    @Id
    private String id;
    private String name;
    private String platform;
    private String url;
}