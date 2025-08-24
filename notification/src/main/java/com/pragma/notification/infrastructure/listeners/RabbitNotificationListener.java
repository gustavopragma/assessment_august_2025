package com.pragma.notification.infrastructure.listeners;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.pragma.notification.application.usecases.NotificationUseCases;
import com.pragma.notification.domain.models.Notification;
import com.pragma.notification.infrastructure.config.RabbitConfig;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class RabbitNotificationListener {
    private final ObjectMapper objectMapper;
    private final NotificationUseCases notificationUseCases;

    public RabbitNotificationListener(ObjectMapper objectMapper, NotificationUseCases notificationUseCases) {
        this.objectMapper = objectMapper;
        this.notificationUseCases = notificationUseCases;
    }

    @RabbitListener(queues = RabbitConfig.QUEUE_NAME)
    public void readNotification(String message) {
        try {
            Notification notification = objectMapper.readValue(message, Notification.class);
            notificationUseCases.saveNotification(notification);
            log.info("Message read for QUEUE {} with BODY {}", RabbitConfig.QUEUE_NAME, message);
        } catch(JsonProcessingException exception) {
            throw new RuntimeException("Error processing notification");
        }
    }
}