package com.services.notification;

import com.services.clients.notification.NotificationRequest;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@AllArgsConstructor
@Service
public class NotificationService {
    private final NotificationRepository notificationRepository;

    public void send(NotificationRequest notificationRequest){
        notificationRepository.save(
                Notification.builder().toCustomerId(notificationRequest.toCustomerId()).toCustomerEmail(notificationRequest.toCustomerEmail()).sender("microservices").message(notificationRequest.message()).sentAt(LocalDateTime.now()).build()
        );
    }
}
