package com.projects.url_shortener.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/shorten")
public class ShortURLController {
    @GetMapping
    public String test() {
        return "URL Shortener Service is up and running!";
    }
}
