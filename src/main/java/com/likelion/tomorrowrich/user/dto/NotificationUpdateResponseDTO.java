package com.likelion.tomorrowrich.user.dto;

public record NotificationUpdateResponseDTO(
        Boolean missionNotification,
        Boolean expenseRecordNotification
) {
}