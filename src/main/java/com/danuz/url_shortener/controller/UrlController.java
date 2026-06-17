package com.danuz.url_shortener.controller;

import com.danuz.url_shortener.dto.UrlRequest;
import com.danuz.url_shortener.dto.UrlResponse;
import com.danuz.url_shortener.dto.UrlStatsResponse;
import com.danuz.url_shortener.service.UrlService;

import jakarta.validation.Valid;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/api/v1/urls")
public class UrlController {

    private final UrlService service;

    public UrlController(UrlService service) {
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<UrlResponse> createShortUrl(
            @Valid @RequestBody UrlRequest request) {

        return ResponseEntity.ok(
                service.createShortUrl(request)
        );
    }

    @GetMapping("/stats/{shortCode}")
    public ResponseEntity<UrlStatsResponse> getStats(
            @PathVariable String shortCode) {

        return ResponseEntity.ok(
                service.getStats(shortCode)
        );
    }

    @DeleteMapping("/{shortCode}")
    public ResponseEntity<Map<String, String>> deleteUrl(
            @PathVariable String shortCode) {

        service.deleteUrl(shortCode);

        return ResponseEntity.ok(
                Map.of(
                        "message",
                        "URL deleted successfully"
                )
        );
    }
}