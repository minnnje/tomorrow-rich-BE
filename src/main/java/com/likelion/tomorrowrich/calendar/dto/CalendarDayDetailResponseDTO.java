package com.likelion.tomorrowrich.calendar.dto;

import java.util.List;

public record CalendarDayDetailResponseDTO(
        String date,
        Integer totalExpenseAmount,
        List<ExpenseDTO> expenses,
        List<MissionDTO> missions
) {
    public record ExpenseDTO(
            Long expenseId,
            String categoryCode,
            String categoryName,
            Integer amount,
            String memo
    ) {
    }

    public record MissionDTO(
            Long missionId,
            String title,
            Integer rewardPoint,
            String status
    ) {
    }
}