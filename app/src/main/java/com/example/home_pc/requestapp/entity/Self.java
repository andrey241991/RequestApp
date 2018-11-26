package com.example.home_pc.requestapp.entity;

import java.util.HashMap;
import java.util.Map;

public class Self {

    private String href;
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    public String getHref() {
        return href;
    }

    public Map<String, Object> getAdditionalProperties() {
        return additionalProperties;
    }
}