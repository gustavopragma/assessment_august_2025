package com.pragma.tournament.application.usecases;

import com.pragma.tournament.domain.models.Notification;
import com.pragma.tournament.domain.repositories.NotificationRepository;
import org.springframework.stereotype.Service;

@Service
public class NotificationUseCases {
    private final NotificationRepository notificationRepository;

    public NotificationUseCases(NotificationRepository notificationRepository) {
        this.notificationRepository = notificationRepository;
    }

    public void sendNotification(Notification notification) {
        notificationRepository.sendNotification(notification);
    }
}