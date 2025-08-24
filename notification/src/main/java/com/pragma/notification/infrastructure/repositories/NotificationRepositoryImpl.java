package com.pragma.notification.infrastructure.repositories;

import com.pragma.notification.domain.models.Notification;
import com.pragma.notification.domain.repositories.NotificationRepository;
import com.pragma.notification.infrastructure.entities.NotificationEntity;
import com.pragma.notification.infrastructure.mappers.NotificationMapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class NotificationRepositoryImpl implements NotificationRepository {
    private  final NotificationMapper notificationMapper;
    private final PostgresNotificationRepository postgresNotificationRepository;

    public NotificationRepositoryImpl(PostgresNotificationRepository postgresNotificationRepository, NotificationMapper notificationMapper) {
        this.postgresNotificationRepository = postgresNotificationRepository;
        this.notificationMapper = notificationMapper;
    }

    @Override
    public void saveNotification(Notification notification) {
        NotificationEntity notificationEntity = notificationMapper.toEntity(notification);
        postgresNotificationRepository.save(notificationEntity);
    }

    @Override
    public List<Notification> getNotificationByTournamentId(String tournamentId) {
        List<NotificationEntity> notificationEntities = postgresNotificationRepository.getNotificationEntitiesByTournamentId(tournamentId);
        return notificationEntities.stream().map(notificationMapper::toModel).toList();
    }
}