package com.example.home_pc.requestapp.entity;

import java.util.HashMap;
import java.util.Map;

public class Links {

    private Self self;
    private Avatar avatar;
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    public Self getSelf() {
        return self;
    }

    public Avatar getAvatar() {
        return avatar;
    }

    public Map<String, Object> getAdditionalProperties() {
        return additionalProperties;
    }
}
