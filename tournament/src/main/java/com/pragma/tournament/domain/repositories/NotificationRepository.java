package com.pragma.tournament.domain.repositories;

import com.pragma.tournament.domain.models.Notification;

public interface NotificationRepository {
    void sendNotification(Notification notification);
}