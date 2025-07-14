package com.zillow.platform.u202417468.pc4307u202417468.q.domain.model.valueobjects;

public enum ELeadSource {
    WEBSITE,
    SOCIAL_MEDIA,
    PHONE;

    public static ELeadSource fromName(String name) {
        if (name == null)
            throw new IllegalArgumentException("Lead source is required");
        return switch (name.trim().toUpperCase().replace(' ', '_')) {
            case "WEBSITE" -> WEBSITE;
            case "SOCIAL_MEDIA" -> SOCIAL_MEDIA;
            case "PHONE" -> PHONE;
            default -> throw new IllegalArgumentException("Invalid lead source: " + name);
        };
    }
}
