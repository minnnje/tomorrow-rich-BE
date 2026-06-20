package com.likelion.tomorrowrich.user.dto;

public record BudgetUpdateRequestDTO(
        Integer monthlyBudget,
        Integer monthlySavingGoal,
        Integer fixedExpense
) {
}