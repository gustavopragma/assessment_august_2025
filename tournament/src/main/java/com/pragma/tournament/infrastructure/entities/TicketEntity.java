package com.pragma.tournament.infrastructure.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity(name = "Ticket")
public class TicketEntity {
    @Id
    private String id;
    private String type;
    private Double price;
    private Integer saleComission;
    private String stage;
    private Boolean active;
    @ManyToOne
    private TournamentEntity tournament;
    @Column(name = "[user]")
    private String user;
}