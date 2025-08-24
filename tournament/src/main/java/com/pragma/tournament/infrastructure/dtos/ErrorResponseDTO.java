package com.pragma.tournament.infrastructure.dtos;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ErrorResponseDTO {
    private String statusCode;
    private String message;
}