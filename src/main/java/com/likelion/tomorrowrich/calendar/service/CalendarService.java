package com.likelion.tomorrowrich.calendar.service;

import com.likelion.tomorrowrich.calendar.dto.CalendarDayDetailResponseDTO;
import com.likelion.tomorrowrich.calendar.dto.CalendarMonthResponseDTO;
import com.likelion.tomorrowrich.expense.entity.Expense;
import com.likelion.tomorrowrich.expense.repository.ExpenseRepository;
import com.likelion.tomorrowrich.global.exception.BusinessException;
import com.likelion.tomorrowrich.global.exception.ErrorCode;
import com.likelion.tomorrowrich.mission.entity.Mission;
import com.likelion.tomorrowrich.mission.entity.MissionStatus;
import com.likelion.tomorrowrich.mission.repository.MissionRepository;
import com.likelion.tomorrowrich.user.entity.User;
import com.likelion.tomorrowrich.user.repository.UserRepository;
import java.time.LocalDate;
import java.time.YearMonth;
import java.time.format.DateTimeParseException;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(readOnly = true)
public class CalendarService {

    private final UserRepository userRepository;
    private final ExpenseRepository expenseRepository;
    private final MissionRepository missionRepository;

    public CalendarService(
            UserRepository userRepository,
            ExpenseRepository expenseRepository,
            MissionRepository missionRepository
    ) {
        this.userRepository = userRepository;
        this.expenseRepository = expenseRepository;
        this.missionRepository = missionRepository;
    }

    public CalendarMonthResponseDTO getMonthlyCalendar(Long userId, String month) {
        User user = findUser(userId);
        YearMonth yearMonth = parseMonth(month);

        LocalDate startDate = yearMonth.atDay(1);
        LocalDate endDate = yearMonth.atEndOfMonth();

        List<Expense> monthlyExpenses = expenseRepository
                .findAllByUserAndExpenseDateBetween(user, startDate, endDate);

        Integer monthlyExpenseAmount = monthlyExpenses.stream()
                .mapToInt(Expense::getAmount)
                .sum();

        Integer monthlyBudget = defaultValue(user.getMonthlyBudget());
        Integer monthlySavingGoal = defaultValue(user.getMonthlySavingGoal());
        Integer remainingBudget = monthlyBudget - monthlyExpenseAmount;
        Integer todayAvailableAmount = calculateTodayAvailableAmount(yearMonth, remainingBudget);

        CalendarMonthResponseDTO.SummaryDTO summary = new CalendarMonthResponseDTO.SummaryDTO(
                monthlyBudget,
                monthlySavingGoal,
                monthlyExpenseAmount,
                remainingBudget,
                todayAvailableAmount
        );

        Map<LocalDate, List<Expense>> expenseMap = monthlyExpenses.stream()
                .collect(Collectors.groupingBy(Expense::getExpenseDate));

        List<CalendarMonthResponseDTO.DayDTO> days = startDate
                .datesUntil(endDate.plusDays(1))
                .map(date -> toDayDTO(user, date, expenseMap.getOrDefault(date, List.of())))
                .toList();

        return new CalendarMonthResponseDTO(
                yearMonth.toString(),
                summary,
                days
        );
    }

    public CalendarDayDetailResponseDTO getDayDetail(Long userId, String dateValue) {
        User user = findUser(userId);
        LocalDate date = parseDate(dateValue);

        validateNotFutureDate(date);

        List<Expense> expenses = expenseRepository
                .findAllByUserAndExpenseDateBetween(user, date, date);

        Integer totalExpenseAmount = expenses.stream()
                .mapToInt(Expense::getAmount)
                .sum();

        List<CalendarDayDetailResponseDTO.ExpenseDTO> expenseDTOs = expenses.stream()
                .map(this::toExpenseDTO)
                .toList();

        List<CalendarDayDetailResponseDTO.MissionDTO> missionDTOs = missionRepository
                .findAllByUserAndMissionDate(user, date)
                .stream()
                .map(this::toMissionDTO)
                .toList();

        return new CalendarDayDetailResponseDTO(
                date.toString(),
                totalExpenseAmount,
                expenseDTOs,
                missionDTOs
        );
    }

    private CalendarMonthResponseDTO.DayDTO toDayDTO(
            User user,
            LocalDate date,
            List<Expense> expenses
    ) {
        Integer totalExpenseAmount = expenses.stream()
                .mapToInt(Expense::getAmount)
                .sum();

        List<Mission> missions = missionRepository.findAllByUserAndMissionDate(user, date);

        int missionTotalCount = missions.size();
        int missionCompletedCount = (int) missions.stream()
                .filter(mission -> mission.getStatus() == MissionStatus.COMPLETED)
                .count();

        return new CalendarMonthResponseDTO.DayDTO(
                date.toString(),
                totalExpenseAmount,
                missionTotalCount,
                missionCompletedCount,
                totalExpenseAmount > 0,
                missionCompletedCount > 0,
                date.isAfter(LocalDate.now())
        );
    }

    private CalendarDayDetailResponseDTO.ExpenseDTO toExpenseDTO(Expense expense) {
        return new CalendarDayDetailResponseDTO.ExpenseDTO(
                expense.getId(),
                expense.getCategory().getCode(),
                expense.getCategory().getName(),
                expense.getAmount(),
                expense.getMemo()
        );
    }

    private CalendarDayDetailResponseDTO.MissionDTO toMissionDTO(Mission mission) {
        return new CalendarDayDetailResponseDTO.MissionDTO(
                mission.getId(),
                mission.getTitle(),
                mission.getRewardPoint(),
                mission.getStatus().name()
        );
    }

    private Integer calculateTodayAvailableAmount(YearMonth targetMonth, Integer remainingBudget) {
        LocalDate today = LocalDate.now();
        YearMonth currentMonth = YearMonth.from(today);

        if (!targetMonth.equals(currentMonth)) {
            return remainingBudget;
        }

        int lastDayOfMonth = currentMonth.atEndOfMonth().getDayOfMonth();
        int todayDayOfMonth = today.getDayOfMonth();
        int remainingDays = lastDayOfMonth - todayDayOfMonth + 1;

        if (remainingDays <= 0) {
            return remainingBudget;
        }

        return remainingBudget / remainingDays;
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

    private LocalDate parseDate(String date) {
        if (date == null || date.isBlank()) {
            throw new BusinessException(ErrorCode.INVALID_DATE_FORMAT);
        }

        try {
            return LocalDate.parse(date);
        } catch (DateTimeParseException exception) {
            throw new BusinessException(ErrorCode.INVALID_DATE_FORMAT);
        }
    }

    private void validateNotFutureDate(LocalDate date) {
        if (date.isAfter(LocalDate.now())) {
            throw new BusinessException(ErrorCode.FUTURE_DATE_NOT_ALLOWED);
        }
    }

    private User findUser(Long userId) {
        return userRepository.findById(userId)
                .orElseThrow(() -> new BusinessException(ErrorCode.UNAUTHORIZED));
    }

    private Integer defaultValue(Integer value) {
        return value == null ? 0 : value;
    }
}