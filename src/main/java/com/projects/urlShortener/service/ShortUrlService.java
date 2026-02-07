package com.projects.urlShortener.service;

import com.projects.urlShortener.dto.ShortenRequest;
import com.projects.urlShortener.dto.ShortenResponse;
import com.projects.urlShortener.model.ShortUrl;
import com.projects.urlShortener.repository.ShortUrlRepository;
import com.projects.urlShortener.util.Base62Encoder;
import java.time.LocalDateTime;
import org.springframework.stereotype.Service;

@Service
public class ShortUrlService {

    private final ShortUrlRepository repository;
    private static final String BASE_URL = "http://localhost:8080/";

    public ShortUrlService(ShortUrlRepository repository) {
        this.repository = repository;
    }

    public ShortenResponse shortenUrl(ShortenRequest request) {
        ShortUrl entity =
                new ShortUrl.Builder()
                        .originalUrl(request.getOriginalUrl())
                        .createdAt(LocalDateTime.now())
                        .build();

        entity = repository.save(entity);

        String shortCode = Base62Encoder.encode(entity.getId());
        entity.setShortCode(shortCode);
        repository.save(entity);

        return new ShortenResponse.Builder()
                .shortUrl(BASE_URL + shortCode)
                .originalUrl(request.getOriginalUrl())
                .createdAt(entity.getCreatedAt())
                .build();
    }

    public String getOriginalUrl(String ShortCode) {
        return repository
                .findByShortCode(ShortCode)
                .map(ShortUrl::getOriginalUrl)
                .orElseThrow(() -> new RuntimeException("Short URL not found"));
    }
}
