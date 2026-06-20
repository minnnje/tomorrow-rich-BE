package com.likelion.tomorrowrich.user.service;

import com.likelion.tomorrowrich.global.exception.BusinessException;
import com.likelion.tomorrowrich.global.exception.ErrorCode;
import com.likelion.tomorrowrich.user.dto.BudgetUpdateRequestDTO;
import com.likelion.tomorrowrich.user.dto.BudgetUpdateResponseDTO;
import com.likelion.tomorrowrich.user.dto.NicknameUpdateRequestDTO;
import com.likelion.tomorrowrich.user.dto.NicknameUpdateResponseDTO;
import com.likelion.tomorrowrich.user.dto.NotificationUpdateRequestDTO;
import com.likelion.tomorrowrich.user.dto.NotificationUpdateResponseDTO;
import com.likelion.tomorrowrich.user.entity.User;
import com.likelion.tomorrowrich.user.repository.UserRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class UserService {

    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public NicknameUpdateResponseDTO updateNickname(
            Long userId,
            NicknameUpdateRequestDTO request
    ) {
        validateNickname(request.nickname());

        User user = findUser(userId);
        user.updateNickname(request.nickname());

        return new NicknameUpdateResponseDTO(user.getNickname());
    }

    public BudgetUpdateResponseDTO updateBudget(
            Long userId,
            BudgetUpdateRequestDTO request
    ) {
        validateBudget(request.monthlyBudget());
        validateSavingGoal(request.monthlySavingGoal());
        validateFixedExpense(request.fixedExpense());

        User user = findUser(userId);
        user.updateBudget(
                request.monthlyBudget(),
                request.monthlySavingGoal(),
                request.fixedExpense()
        );

        return new BudgetUpdateResponseDTO(
                user.getMonthlyBudget(),
                user.getMonthlySavingGoal(),
                user.getFixedExpense()
        );
    }

    public NotificationUpdateResponseDTO updateNotification(
            Long userId,
            NotificationUpdateRequestDTO request
    ) {
        validateNotification(request);

        User user = findUser(userId);
        user.updateNotification(
                request.missionNotification(),
                request.expenseRecordNotification()
        );

        return new NotificationUpdateResponseDTO(
                user.getMissionNotification(),
                user.getExpenseRecordNotification()
        );
    }

    private User findUser(Long userId) {
        return userRepository.findById(userId)
                .orElseThrow(() -> new BusinessException(ErrorCode.UNAUTHORIZED));
    }

    private void validateNickname(String nickname) {
        if (nickname == null || nickname.isBlank()) {
            throw new BusinessException(ErrorCode.EMPTY_NICKNAME);
        }
    }

    private void validateBudget(Integer monthlyBudget) {
        if (monthlyBudget == null || monthlyBudget <= 0) {
            throw new BusinessException(ErrorCode.INVALID_BUDGET);
        }
    }

    private void validateSavingGoal(Integer monthlySavingGoal) {
        if (monthlySavingGoal == null || monthlySavingGoal < 0) {
            throw new BusinessException(ErrorCode.INVALID_SAVING_GOAL);
        }
    }

    private void validateFixedExpense(Integer fixedExpense) {
        if (fixedExpense != null && fixedExpense < 0) {
            throw new BusinessException(ErrorCode.INVALID_BUDGET);
        }
    }

    private void validateNotification(NotificationUpdateRequestDTO request) {
        if (request.missionNotification() == null || request.expenseRecordNotification() == null) {
            throw new BusinessException(ErrorCode.INVALID_REQUEST);
        }
    }
}