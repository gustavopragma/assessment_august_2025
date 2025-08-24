package com.pragma.tournament.application.usecases;

import com.pragma.tournament.domain.models.Notification;
import com.pragma.tournament.domain.repositories.NotificationRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class NotificationUseCasesTests {

    private Notification notification;

    @Mock
    private NotificationRepository notificationRepository;

    @InjectMocks
    private NotificationUseCases notificationUseCases;

    @BeforeEach
    public void setUp() {
        notification = new Notification();
        notification.setType("Type 1");
        notification.setMessage("Notification message");
        notification.setId("1234");
        notification.setTournament("1234");
    }

    @Test
    public void sendNotificationTests() {
        doNothing().when(notificationRepository).sendNotification(notification);
        notificationUseCases.sendNotification(notification);
        verify(notificationRepository, times(1)).sendNotification(notification);
    }
}