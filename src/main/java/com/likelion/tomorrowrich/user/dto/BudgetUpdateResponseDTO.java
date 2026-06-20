package com.likelion.tomorrowrich.user.dto;

public record BudgetUpdateResponseDTO(
        Integer monthlyBudget,
        Integer monthlySavingGoal,
        Integer fixedExpense
) {
}