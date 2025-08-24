package com.pragma.tournament.infrastructure.dtos;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class TotalSpectatorsResponseDTO {
    private Integer totalSpectators;
}