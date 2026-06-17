package com.danuz.url_shortener.service;

import com.danuz.url_shortener.dto.UrlRequest;
import com.danuz.url_shortener.dto.UrlResponse;
import com.danuz.url_shortener.dto.UrlStatsResponse;
import com.danuz.url_shortener.entity.Url;
import com.danuz.url_shortener.exception.UrlNotFoundException;
import com.danuz.url_shortener.repository.UrlRepository;
import com.danuz.url_shortener.util.Base62Util;

import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class UrlServiceImpl implements UrlService {

    private final UrlRepository repository;

    public UrlServiceImpl(UrlRepository repository) {
        this.repository = repository;
    }

    @Override
    public UrlResponse createShortUrl(UrlRequest request) {

        Url url = new Url();

        url.setOriginalUrl(request.originalUrl());
        url.setClickCount(0L);
        url.setCreatedAt(LocalDateTime.now());

        repository.save(url);

        String shortCode = Base62Util.encode(url.getId());

        url.setShortCode(shortCode);

        repository.save(url);

        return new UrlResponse(
                url.getOriginalUrl(),
                shortCode,
                "http://localhost:8081/" + shortCode
        );
    }

    @Override
    public Url redirect(String shortCode) {

        Url url = repository
                .findByShortCode(shortCode)
                .orElseThrow(() ->
                        new UrlNotFoundException(shortCode));

        url.setClickCount(
                url.getClickCount() + 1);

        repository.save(url);

        return url;
    }

    @Override
    public UrlStatsResponse getStats(String shortCode) {

        Url url = repository
                .findByShortCode(shortCode)
                .orElseThrow(() ->
                        new UrlNotFoundException(shortCode));

        return new UrlStatsResponse(
                url.getOriginalUrl(),
                url.getShortCode(),
                url.getClickCount(),
                url.getCreatedAt()
        );
    }

    @Override
    public void deleteUrl(String shortCode) {

        Url url = repository
                .findByShortCode(shortCode)
                .orElseThrow(() ->
                        new UrlNotFoundException(shortCode));

        repository.delete(url);
    }
}