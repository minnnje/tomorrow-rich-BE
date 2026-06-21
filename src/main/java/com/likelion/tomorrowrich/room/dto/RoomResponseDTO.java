package com.likelion.tomorrowrich.room.dto;

import java.util.List;

public record RoomResponseDTO(
        Long roomId,
        String characterName,
        Integer currentPoint,
        List<ItemDTO> appliedItems
) {
    public record ItemDTO(
            Long itemId,
            String name,
            String itemType,
            String imageUrl
    ) {
    }
}