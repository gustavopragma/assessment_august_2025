package com.pragma.tournament.infrastructure.dtos;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class TotalParticipantsResponseDTO {
    private Integer totalParticipants;
}