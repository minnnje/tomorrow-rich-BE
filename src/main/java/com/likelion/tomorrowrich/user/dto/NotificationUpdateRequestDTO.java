package com.likelion.tomorrowrich.user.dto;

public record NotificationUpdateRequestDTO(
        Boolean missionNotification,
        Boolean expenseRecordNotification
) {
}