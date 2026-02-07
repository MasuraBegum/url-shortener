package com.projects.urlShortener.dto;

import java.time.LocalDateTime;

public class ShortenResponse {
    private String shortUrl;
    private String originalUrl;
    private LocalDateTime createdAt;

    private ShortenResponse(Builder builder) {
        this.shortUrl = builder.shortUrl;
        this.originalUrl = builder.originalUrl;
        this.createdAt = builder.createdAt;
    }

    public static class Builder {
        private String shortUrl;
        private String originalUrl;
        private LocalDateTime createdAt;

        public Builder shortUrl(String shortUrl) {
            this.shortUrl = shortUrl;
            return this;
        }

        public Builder originalUrl(String originalUrl) {
            this.originalUrl = originalUrl;
            return this;
        }

        public Builder createdAt(LocalDateTime createdAt) {
            this.createdAt = createdAt;
            return this;
        }

        public ShortenResponse build() {
            return new ShortenResponse(this);
        }
    }
}
