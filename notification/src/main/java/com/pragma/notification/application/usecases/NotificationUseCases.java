package com.pragma.notification.application.usecases;

import com.pragma.notification.domain.models.Notification;
import com.pragma.notification.domain.repositories.NotificationRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NotificationUseCases {
    private final NotificationRepository notificationRepository;

    public NotificationUseCases(NotificationRepository notificationRepository) {
        this.notificationRepository = notificationRepository;
    }

    public String saveNotification(Notification notification) {
        notificationRepository.saveNotification(notification);
        return notification.getId();
    }

    public List<Notification> getNotificationsByTournamentId(String tournamentId) {
        return notificationRepository.getNotificationByTournamentId(tournamentId);
    }
}