package com.danuz.url_shortener.service;

import com.danuz.url_shortener.dto.UrlStatsResponse;
import com.danuz.url_shortener.entity.Url;
import com.danuz.url_shortener.exception.UrlNotFoundException;
import com.danuz.url_shortener.repository.UrlRepository;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDateTime;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class UrlServiceImplTest {

    @Mock
    private UrlRepository repository;

    @InjectMocks
    private UrlServiceImpl service;

    @Test
    void shouldReturnStatsWhenUrlExists() {

        Url url = new Url();

        url.setOriginalUrl("https://www.google.com");
        url.setShortCode("5");
        url.setClickCount(10L);
        url.setCreatedAt(LocalDateTime.now());

        when(repository.findByShortCode("5"))
                .thenReturn(Optional.of(url));

        UrlStatsResponse response =
                service.getStats("5");

        assertEquals(
                "https://www.google.com",
                response.originalUrl());

        assertEquals(
                "5",
                response.shortCode());

        assertEquals(
                10L,
                response.clickCount());
    }

    @Test
    void shouldThrowExceptionWhenUrlDoesNotExist() {

        when(repository.findByShortCode("999"))
                .thenReturn(Optional.empty());

        assertThrows(
                UrlNotFoundException.class,
                () -> service.getStats("999"));
    }
}