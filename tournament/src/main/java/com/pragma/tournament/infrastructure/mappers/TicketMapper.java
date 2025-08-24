package com.pragma.tournament.infrastructure.mappers;

import com.pragma.tournament.domain.models.Ticket;
import com.pragma.tournament.infrastructure.entities.TicketEntity;
import org.springframework.stereotype.Component;

@Component
public class TicketMapper implements Mapper<TicketEntity, Ticket>{
    @Override
    public TicketEntity toEntity(Ticket model) {
        return TicketEntity.builder()
                .id(model.getId())
                .active(model.getActive())
                .price(model.getPrice())
                .saleComission(model.getSaleComission())
                .stage(model.getStage())
                .type(model.getType())
                .user(model.getUser())
                .build();
    }

    @Override
    public Ticket toModel(TicketEntity entity) {
        Ticket ticket = new Ticket();
        ticket.setId(entity.getId());
        ticket.setActive(entity.getActive());
        ticket.setPrice(entity.getPrice());
        ticket.setStage(entity.getStage());
        ticket.setType(entity.getType());
        ticket.setSaleComission(entity.getSaleComission());
        ticket.setTournament(entity.getTournament().getId());
        ticket.setUser(entity.getUser());
        return ticket;
    }
}