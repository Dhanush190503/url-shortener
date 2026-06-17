package com.danuz.url_shortener.service;

import com.danuz.url_shortener.dto.UrlRequest;
import com.danuz.url_shortener.dto.UrlResponse;
import com.danuz.url_shortener.dto.UrlStatsResponse;
import com.danuz.url_shortener.entity.Url;

public interface UrlService {

    UrlResponse createShortUrl(UrlRequest request);

    Url redirect(String shortCode);

    UrlStatsResponse getStats(String shortCode);

    void deleteUrl(String shortCode);
}