package com.pragma.notification.infrastructure.controllers;

import com.pragma.notification.application.usecases.NotificationUseCases;
import com.pragma.notification.domain.models.Notification;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping(value = "/api/v1/notifications")
public class NotificationController {
    private final NotificationUseCases notificationUseCases;

    public NotificationController(NotificationUseCases notificationUseCases) {
        this.notificationUseCases = notificationUseCases;
    }

    @GetMapping(value = "/tournaments/{tournamentId}")
    public List<Notification> getNotificationsByTournamentId(@PathVariable(value = "tournamentId") String tournamentId) {
        return notificationUseCases.getNotificationsByTournamentId(tournamentId);
    }
}