package com.danuz.url_shortener.controller;

import com.danuz.url_shortener.entity.Url;
import com.danuz.url_shortener.service.UrlService;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;

@RestController
public class RedirectController {

    private final UrlService service;

    public RedirectController(UrlService service) {
        this.service = service;
    }

    @GetMapping("/{shortCode}")
    public ResponseEntity<Void> redirect(
            @PathVariable String shortCode) {

        Url url = service.redirect(shortCode);

        return ResponseEntity
                .status(HttpStatus.FOUND)
                .location(
                        URI.create(
                                url.getOriginalUrl()))
                .build();
    }
}