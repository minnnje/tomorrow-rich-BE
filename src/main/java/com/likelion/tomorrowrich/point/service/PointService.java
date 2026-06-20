package com.likelion.tomorrowrich.point.service;

import com.likelion.tomorrowrich.global.exception.BusinessException;
import com.likelion.tomorrowrich.global.exception.ErrorCode;
import com.likelion.tomorrowrich.point.dto.PointHistoryResponseDTO;
import com.likelion.tomorrowrich.point.entity.PointHistory;
import com.likelion.tomorrowrich.point.repository.PointHistoryRepository;
import com.likelion.tomorrowrich.user.entity.User;
import com.likelion.tomorrowrich.user.repository.UserRepository;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.YearMonth;
import java.time.format.DateTimeParseException;
import java.util.List;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(readOnly = true)
public class PointService {

    private final UserRepository userRepository;
    private final PointHistoryRepository pointHistoryRepository;

    public PointService(
            UserRepository userRepository,
            PointHistoryRepository pointHistoryRepository
    ) {
        this.userRepository = userRepository;
        this.pointHistoryRepository = pointHistoryRepository;
    }

    public PointHistoryResponseDTO getPointHistories(Long userId, String month) {
        User user = findUser(userId);
        YearMonth yearMonth = parseMonth(month);

        LocalDate startDate = yearMonth.atDay(1);
        LocalDate endDate = yearMonth.atEndOfMonth();

        LocalDateTime startDateTime = startDate.atStartOfDay();
        LocalDateTime endDateTime = endDate.plusDays(1).atStartOfDay();

        List<PointHistoryResponseDTO.PointHistoryDTO> histories = pointHistoryRepository
                .findAllByUserAndCreatedAtBetweenOrderByCreatedAtDesc(
                        user,
                        startDateTime,
                        endDateTime
                )
                .stream()
                .map(this::toPointHistoryDTO)
                .toList();

        return new PointHistoryResponseDTO(
                user.getCurrentPoint(),
                histories
        );
    }

    private PointHistoryResponseDTO.PointHistoryDTO toPointHistoryDTO(PointHistory pointHistory) {
        return new PointHistoryResponseDTO.PointHistoryDTO(
                pointHistory.getId(),
                pointHistory.getType().name(),
                pointHistory.getAmount(),
                pointHistory.getReason(),
                pointHistory.getCreatedAt().toString()
        );
    }

    private YearMonth parseMonth(String month) {
        if (month == null || month.isBlank()) {
            throw new BusinessException(ErrorCode.INVALID_MONTH_FORMAT);
        }

        try {
            return YearMonth.parse(month);
        } catch (DateTimeParseException exception) {
            throw new BusinessException(ErrorCode.INVALID_MONTH_FORMAT);
        }
    }

    private User findUser(Long userId) {
        return userRepository.findById(userId)
                .orElseThrow(() -> new BusinessException(ErrorCode.UNAUTHORIZED));
    }
}