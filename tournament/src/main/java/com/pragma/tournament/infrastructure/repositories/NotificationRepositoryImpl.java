package com.pragma.tournament.infrastructure.repositories;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.pragma.tournament.domain.models.Notification;
import com.pragma.tournament.domain.repositories.NotificationRepository;
import com.pragma.tournament.infrastructure.mq.RabbitConfig;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Repository;

@Slf4j
@Repository
public class NotificationRepositoryImpl implements NotificationRepository {
    private final RabbitTemplate rabbitTemplate;
    private final ObjectMapper objectMapper;

    public NotificationRepositoryImpl(RabbitTemplate rabbitTemplate, ObjectMapper objectMapper) {
        this.rabbitTemplate = rabbitTemplate;
        this.objectMapper = objectMapper;
    }

    @Override
    public void sendNotification(Notification notification) {
        try {
            String notificationJson = objectMapper.writeValueAsString(notification);
            rabbitTemplate.convertAndSend(RabbitConfig.EXCHANGE_NAME, RabbitConfig.ROUTING_KEY, notificationJson);
            log.info("Message send to queue BODY {}", notificationJson);
        } catch (JsonProcessingException e) {
            throw new RuntimeException("An error processing notification occurs");
        }
    }
}