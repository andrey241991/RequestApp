package com.example.home_pc.requestapp.entity;

import java.util.HashMap;
import java.util.Map;

public class RateLimit {

    private int limit;
    private int remaining;
    private int reset;
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    public int getLimit() {
        return limit;
    }

    public int getRemaining() {
        return remaining;
    }

    public int getReset() {
        return reset;
    }

    public Map<String, Object> getAdditionalProperties() {
        return additionalProperties;
    }
}