package com.example.urlshorter.service;

import com.example.urlshorter.model.ShortingEntity;
import com.example.urlshorter.repository.UrlRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.Map;
import java.util.UUID;
import java.util.function.Function;

@Service
public class ShorterService {

    private UrlRepository urlRepository;

    private String domain;

    private String fallbackUrl;

    @Autowired
    public ShorterService(UrlRepository urlRepository,
                          @Value("${shorter.domain}") String domain,
                          @Value("${shorter.fallbackUrl") String fallbackUrl) {
        this.urlRepository = urlRepository;
        this.domain = domain;
        this.fallbackUrl = fallbackUrl;
    }

    public String shortenAndSave(String url, Map<String, String> context) {
        String key = getKey(url);
        ShortingEntity shortingEntity = new ShortingEntity()
                .setKey(key)
                .setUrl(url)
                .setContext(context);
        ShortingEntity saved = urlRepository.save(shortingEntity);
        return domain  + "/" + saved.getKey();
    }

    public String elongate(String key) {
        return urlRepository.findById(key)
                .map(ShortingEntity::getUrl)
                .orElse(fallbackUrl);
    }

    // for now any random will suffice
    private String getKey(String url) {
        return UUID.randomUUID().toString();
    }

}
