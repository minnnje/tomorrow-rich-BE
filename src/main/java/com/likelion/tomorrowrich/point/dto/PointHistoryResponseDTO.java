package com.likelion.tomorrowrich.point.dto;

import java.util.List;

public record PointHistoryResponseDTO(
        Integer currentPoint,
        List<PointHistoryDTO> histories
) {
    public record PointHistoryDTO(
            Long pointHistoryId,
            String type,
            Integer amount,
            String reason,
            String createdAt
    ) {
    }
}