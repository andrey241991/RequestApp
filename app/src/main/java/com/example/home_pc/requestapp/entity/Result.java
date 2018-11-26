package com.example.home_pc.requestapp.entity;

import java.util.HashMap;
import java.util.Map;

public class Result {

    private String id;
    private String name;
    private String gender;
    private String dob;
    private String email;
    private String phone;
    private String website;
    private String address;
    private String status;
    private Links links;
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getGender() {
        return gender;
    }

    public String getDob() {
        return dob;
    }

    public String getEmail() {
        return email;
    }

    public String getPhone() {
        return phone;
    }

    public String getWebsite() {
        return website;
    }

    public String getAddress() {
        return address;
    }

    public String getStatus() {
        return status;
    }

    public Links getLinks() {
        return links;
    }

    public Map<String, Object> getAdditionalProperties() {
        return additionalProperties;
    }
}