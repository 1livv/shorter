package com.example.urlshorter.model;

import org.hibernate.validator.constraints.URL;
import java.util.Map;
import javax.validation.constraints.NotNull;

public class ShortningRequest {

    @URL
    @NotNull
    private String url;

    private Map<String, String> context;

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public Map<String, String> getContext() {
        return context;
    }

    public void setContext(Map<String, String> context) {
        this.context = context;
    }

}
