package com.pragma.notification.infrastructure.repositories;

import com.pragma.notification.infrastructure.entities.NotificationEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PostgresNotificationRepository extends JpaRepository<NotificationEntity, String> {
    List<NotificationEntity> getNotificationEntitiesByTournamentId(String tournamentId);
}
