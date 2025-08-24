package com.pragma.notification.domain.repositories;

import com.pragma.notification.domain.models.Notification;

import java.util.List;

public interface NotificationRepository {
    void saveNotification(Notification notification);
    List<Notification> getNotificationByTournamentId(String tournamentId);
}