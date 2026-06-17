package com.danuz.url_shortener.dto;

public record UrlResponse(
        String originalUrl,
        String shortCode,
        String shortUrl
) {
}