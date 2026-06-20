package com.likelion.tomorrowrich.mypage.service;

import com.likelion.tomorrowrich.global.exception.BusinessException;
import com.likelion.tomorrowrich.global.exception.ErrorCode;
import com.likelion.tomorrowrich.mypage.dto.MypageResponseDTO;
import com.likelion.tomorrowrich.user.entity.User;
import com.likelion.tomorrowrich.user.repository.UserRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(readOnly = true)
public class MypageService {

    private static final String DEFAULT_NICKNAME = "사용자";
    private static final String DEFAULT_CHARACTER_NAME = "말랑이";

    private final UserRepository userRepository;

    public MypageService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public MypageResponseDTO getMypage(Long userId) {
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new BusinessException(ErrorCode.MYPAGE_LOAD_FAILED));

        return new MypageResponseDTO(
                user.getId(),
                defaultString(user.getNickname(), DEFAULT_NICKNAME),
                defaultString(user.getCharacterName(), DEFAULT_CHARACTER_NAME),
                defaultValue(user.getCurrentPoint()),
                defaultValue(user.getMonthlyBudget()),
                defaultValue(user.getMonthlySavingGoal()),
                defaultValue(user.getFixedExpense()),
                new MypageResponseDTO.NotificationSettingsDTO(
                        user.getMissionNotification(),
                        user.getExpenseRecordNotification()
                )
        );
    }

    private Integer defaultValue(Integer value) {
        return value == null ? 0 : value;
    }

    private String defaultString(String value, String defaultValue) {
        if (value == null || value.isBlank()) {
            return defaultValue;
        }

        return value;
    }
}