package com.services.clients.notification;

public record NotificationRequest(Long toCustomerId, String toCustomerEmail, String message) {
}