package com.likelion.tomorrowrich.shop.dto;

public record ShopItemDTO(
        Long itemId,
        String name,
        String itemType,
        Integer price,
        String imageUrl,
        Boolean owned,
        Boolean applied
) {
}