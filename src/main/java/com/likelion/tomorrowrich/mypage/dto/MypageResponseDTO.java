package com.likelion.tomorrowrich.mypage.dto;

public record MypageResponseDTO(
        Long userId,
        String nickname,
        String characterName,
        Integer currentPoint,
        Integer monthlyBudget,
        Integer monthlySavingGoal,
        Integer fixedExpense,
        NotificationSettingsDTO notificationSettings
) {
    public record NotificationSettingsDTO(
            Boolean missionNotification,
            Boolean expenseRecordNotification
    ) {
    }
}