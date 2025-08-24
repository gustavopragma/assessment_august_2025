package com.pragma.tournament.infrastructure.controllers;

import com.pragma.tournament.domain.exceptions.AlreadyExistsException;
import com.pragma.tournament.domain.exceptions.NotFoundException;
import com.pragma.tournament.infrastructure.dtos.ErrorResponseDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalErrorController {

    @ExceptionHandler(NotFoundException.class)
    public ResponseEntity<ErrorResponseDTO> handleNotFoundException(NotFoundException ex) {
        ErrorResponseDTO errorResponseDTO = ErrorResponseDTO.builder()
                .statusCode("404")
                .message(ex.getMessage())
                .build();
        return ResponseEntity.status(404).body(errorResponseDTO);
    }

    @ExceptionHandler(AlreadyExistsException.class)
    public ResponseEntity<ErrorResponseDTO> handleAlreadyExistsException(AlreadyExistsException ex) {
        ErrorResponseDTO errorResponseDTO = ErrorResponseDTO.builder()
                .statusCode("400")
                .message(ex.getMessage())
                .build();
        return ResponseEntity.status(400).body(errorResponseDTO);
    }
}