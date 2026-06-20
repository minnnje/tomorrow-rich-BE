package com.likelion.tomorrowrich.shop.dto;

public record ItemPurchaseResponseDTO(
        Long itemId,
        String name,
        Integer price,
        Integer currentPoint,
        Boolean owned
) {
}