package com.likelion.tomorrowrich.room.controller;

import com.likelion.tomorrowrich.global.security.SecurityUtil;
import com.likelion.tomorrowrich.room.dto.InventoryItemListResponseDTO;
import com.likelion.tomorrowrich.room.dto.ItemApplyResponseDTO;
import com.likelion.tomorrowrich.room.dto.ItemUnapplyResponseDTO;
import com.likelion.tomorrowrich.room.dto.RoomResponseDTO;
import com.likelion.tomorrowrich.room.service.RoomService;
import java.util.List;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/room")
public class RoomController {

    private final RoomService roomService;
    private final SecurityUtil securityUtil;

    public RoomController(
            RoomService roomService,
            SecurityUtil securityUtil
    ) {
        this.roomService = roomService;
        this.securityUtil = securityUtil;
    }

    @GetMapping
    public ResponseEntity<RoomResponseDTO> getRoom() {
        Long userId = securityUtil.getCurrentUserId();

        RoomResponseDTO response = roomService.getRoom(userId);

        return ResponseEntity.ok(response);
    }

    @GetMapping("/inventory")
    public ResponseEntity<List<InventoryItemListResponseDTO>> getInventoryItems(
            @RequestParam(required = false) String type
    ) {
        Long userId = securityUtil.getCurrentUserId();

        List<InventoryItemListResponseDTO> response = roomService.getInventoryItems(userId, type);

        return ResponseEntity.ok(response);
    }

    @PatchMapping("/items/{itemId}/apply")
    public ResponseEntity<ItemApplyResponseDTO> applyItem(
            @PathVariable Long itemId
    ) {
        Long userId = securityUtil.getCurrentUserId();

        ItemApplyResponseDTO response = roomService.applyItem(userId, itemId);

        return ResponseEntity.ok(response);
    }

    @PatchMapping("/items/{itemId}/unapply")
    public ResponseEntity<ItemUnapplyResponseDTO> unapplyItem(
            @PathVariable Long itemId
    ) {
        Long userId = securityUtil.getCurrentUserId();

        ItemUnapplyResponseDTO response = roomService.unapplyItem(userId, itemId);

        return ResponseEntity.ok(response);
    }
}