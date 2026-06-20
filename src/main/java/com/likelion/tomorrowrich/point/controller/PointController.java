package com.likelion.tomorrowrich.point.controller;

import com.likelion.tomorrowrich.global.security.SecurityUtil;
import com.likelion.tomorrowrich.point.dto.PointHistoryResponseDTO;
import com.likelion.tomorrowrich.point.service.PointService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/points")
public class PointController {

    private final PointService pointService;
    private final SecurityUtil securityUtil;

    public PointController(
            PointService pointService,
            SecurityUtil securityUtil
    ) {
        this.pointService = pointService;
        this.securityUtil = securityUtil;
    }

    @GetMapping("/history")
    public ResponseEntity<PointHistoryResponseDTO> getPointHistories(
            @RequestParam String month
    ) {
        Long userId = securityUtil.getCurrentUserId();

        PointHistoryResponseDTO response = pointService.getPointHistories(userId, month);

        return ResponseEntity.ok(response);
    }
}