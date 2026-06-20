package com.likelion.tomorrowrich.room.dto;

import java.util.List;

public record ItemApplyResponseDTO(
        Long itemId,
        Boolean applied,
        RoomDTO room
) {
    public record RoomDTO(
            List<RoomResponseDTO.ItemDTO> appliedItems
    ) {
    }
}