package com.likelion.tomorrowrich.mypage.controller;

import com.likelion.tomorrowrich.global.security.SecurityUtil;
import com.likelion.tomorrowrich.mypage.dto.MypageResponseDTO;
import com.likelion.tomorrowrich.mypage.service.MypageService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/mypage")
public class MypageController {

    private final MypageService mypageService;
    private final SecurityUtil securityUtil;

    public MypageController(
            MypageService mypageService,
            SecurityUtil securityUtil
    ) {
        this.mypageService = mypageService;
        this.securityUtil = securityUtil;
    }

    @GetMapping
    public ResponseEntity<MypageResponseDTO> getMypage() {
        Long userId = securityUtil.getCurrentUserId();

        MypageResponseDTO response = mypageService.getMypage(userId);

        return ResponseEntity.ok(response);
    }
}