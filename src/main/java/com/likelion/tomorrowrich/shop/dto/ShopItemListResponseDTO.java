package com.likelion.tomorrowrich.shop.dto;

import java.util.List;

public record ShopItemListResponseDTO(
        Integer currentPoint,
        List<ShopItemDTO> items
) {
}