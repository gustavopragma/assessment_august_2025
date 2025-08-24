package com.pragma.notification.infrastructure.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity(name = "Notification")
public class NotificationEntity {
    @Id
    private String id;
    private String type;
    private String message;
    private String tournamentId;
}