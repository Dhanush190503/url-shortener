package com.danuz.url_shortener.exception;

public class UrlNotFoundException extends RuntimeException {

    public UrlNotFoundException(String shortCode) {
        super("URL not found: " + shortCode);
    }
}