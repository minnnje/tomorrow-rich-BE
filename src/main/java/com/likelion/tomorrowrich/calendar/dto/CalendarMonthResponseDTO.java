package com.likelion.tomorrowrich.calendar.dto;

import java.util.List;

public record CalendarMonthResponseDTO(
        String month,
        SummaryDTO summary,
        List<DayDTO> days
) {
    public record SummaryDTO(
            Integer monthlyBudget,
            Integer monthlySavingGoal,
            Integer monthlyExpenseAmount,
            Integer remainingBudget,
            Integer todayAvailableAmount
    ) {
    }

    public record DayDTO(
            String date,
            Integer totalExpenseAmount,
            Integer missionTotalCount,
            Integer missionCompletedCount,
            Boolean hasExpense,
            Boolean hasCompletedMission,
            Boolean isFuture
    ) {
    }
}