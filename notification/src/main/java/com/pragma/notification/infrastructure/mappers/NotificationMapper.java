package com.pragma.notification.infrastructure.mappers;

import com.pragma.notification.domain.models.Notification;
import com.pragma.notification.infrastructure.entities.NotificationEntity;
import org.springframework.stereotype.Component;

@Component
public class NotificationMapper implements Mapper<NotificationEntity, Notification> {
    @Override
    public NotificationEntity toEntity(Notification model) {
        return NotificationEntity.builder()
                .id(model.getId())
                .type(model.getType())
                .message(model.getMessage())
                .tournamentId(model.getTournament())
                .build();
    }

    @Override
    public Notification toModel(NotificationEntity entity) {
        Notification notification = new Notification();
        notification.setId(entity.getId());
        notification.setMessage(entity.getMessage());
        notification.setType(entity.getType());
        notification.setTournament(entity.getTournamentId());
        return notification;
    }
}