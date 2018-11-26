package com.example.home_pc.requestapp.entity;

import java.util.HashMap;
import java.util.Map;

public class Meta {

    private boolean success;
    private int code;
    private String message;
    private int totalCount;
    private int pageCount;
    private int currentPage;
    private int perPage;
    private RateLimit rateLimit;
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    public boolean isSuccess() {
        return success;
    }

    public int getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }

    public int getTotalCount() {
        return totalCount;
    }

    public int getPageCount() {
        return pageCount;
    }

    public int getCurrentPage() {
        return currentPage;
    }

    public int getPerPage() {
        return perPage;
    }

    public RateLimit getRateLimit() {
        return rateLimit;
    }

    public Map<String, Object> getAdditionalProperties() {
        return additionalProperties;
    }
}
