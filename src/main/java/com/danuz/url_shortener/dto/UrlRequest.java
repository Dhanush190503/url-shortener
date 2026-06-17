package com.danuz.url_shortener.dto;

import jakarta.validation.constraints.NotBlank;

public record UrlRequest(

        @NotBlank(message = "Original URL is required")
        String originalUrl

) {
}