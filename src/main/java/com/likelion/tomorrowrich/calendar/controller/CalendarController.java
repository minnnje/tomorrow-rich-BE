package com.likelion.tomorrowrich.calendar.controller;

import com.likelion.tomorrowrich.calendar.dto.CalendarDayDetailResponseDTO;
import com.likelion.tomorrowrich.calendar.dto.CalendarMonthResponseDTO;
import com.likelion.tomorrowrich.calendar.service.CalendarService;
import com.likelion.tomorrowrich.global.security.SecurityUtil;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/calendar")
public class CalendarController {

    private final CalendarService calendarService;
    private final SecurityUtil securityUtil;

    public CalendarController(
            CalendarService calendarService,
            SecurityUtil securityUtil
    ) {
        this.calendarService = calendarService;
        this.securityUtil = securityUtil;
    }

    @GetMapping
    public ResponseEntity<CalendarMonthResponseDTO> getMonthlyCalendar(
            @RequestParam String month
    ) {
        Long userId = securityUtil.getCurrentUserId();

        CalendarMonthResponseDTO response = calendarService.getMonthlyCalendar(userId, month);

        return ResponseEntity.ok(response);
    }

    @GetMapping("/days/{date}")
    public ResponseEntity<CalendarDayDetailResponseDTO> getDayDetail(
            @PathVariable String date
    ) {
        Long userId = securityUtil.getCurrentUserId();

        CalendarDayDetailResponseDTO response = calendarService.getDayDetail(userId, date);

        return ResponseEntity.ok(response);
    }
}