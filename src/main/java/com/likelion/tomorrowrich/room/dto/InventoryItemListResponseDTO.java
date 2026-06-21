package com.likelion.tomorrowrich.room.dto;

public record InventoryItemListResponseDTO(
        Long itemId,
        String name,
        String itemType,
        String imageUrl,
        Boolean applied
) {
}