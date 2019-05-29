package com.example.urlshorter.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Map;

@Document(collection = "urls")
public class ShortingEntity {

    @Id
    private String key;

    private String url;

    private Map<String, String> context;

    public String getKey() {
        return key;
    }

    public ShortingEntity setKey(String key) {
        this.key = key;
        return this;
    }

    public String getUrl() {
        return url;
    }

    public ShortingEntity setUrl(String url) {
        this.url = url;
        return this;
    }

    public Map<String, String> getContext() {
        return context;
    }

    public ShortingEntity setContext(Map<String, String> context) {
        this.context = context;
        return this;
    }
}
