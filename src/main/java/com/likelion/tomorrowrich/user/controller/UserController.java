package com.likelion.tomorrowrich.user.controller;

import com.likelion.tomorrowrich.global.security.SecurityUtil;
import com.likelion.tomorrowrich.user.dto.BudgetUpdateRequestDTO;
import com.likelion.tomorrowrich.user.dto.BudgetUpdateResponseDTO;
import com.likelion.tomorrowrich.user.dto.NicknameUpdateRequestDTO;
import com.likelion.tomorrowrich.user.dto.NicknameUpdateResponseDTO;
import com.likelion.tomorrowrich.user.dto.NotificationUpdateRequestDTO;
import com.likelion.tomorrowrich.user.dto.NotificationUpdateResponseDTO;
import com.likelion.tomorrowrich.user.service.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/users/me")
public class UserController {

    private final UserService userService;
    private final SecurityUtil securityUtil;

    public UserController(
            UserService userService,
            SecurityUtil securityUtil
    ) {
        this.userService = userService;
        this.securityUtil = securityUtil;
    }

    @PatchMapping("/nickname")
    public ResponseEntity<NicknameUpdateResponseDTO> updateNickname(
            @RequestBody NicknameUpdateRequestDTO request
    ) {
        Long userId = securityUtil.getCurrentUserId();

        NicknameUpdateResponseDTO response = userService.updateNickname(userId, request);

        return ResponseEntity.ok(response);
    }

    @PatchMapping("/budget")
    public ResponseEntity<BudgetUpdateResponseDTO> updateBudget(
            @RequestBody BudgetUpdateRequestDTO request
    ) {
        Long userId = securityUtil.getCurrentUserId();

        BudgetUpdateResponseDTO response = userService.updateBudget(userId, request);

        return ResponseEntity.ok(response);
    }

    @PatchMapping("/notifications")
    public ResponseEntity<NotificationUpdateResponseDTO> updateNotification(
            @RequestBody NotificationUpdateRequestDTO request
    ) {
        Long userId = securityUtil.getCurrentUserId();

        NotificationUpdateResponseDTO response = userService.updateNotification(userId, request);

        return ResponseEntity.ok(response);
    }
}