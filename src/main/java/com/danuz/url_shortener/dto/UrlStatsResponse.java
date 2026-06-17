package com.danuz.url_shortener.dto;

import java.time.LocalDateTime;

public record UrlStatsResponse(
        String originalUrl,
        String shortCode,
        Long clickCount,
        LocalDateTime createdAt
) {
}