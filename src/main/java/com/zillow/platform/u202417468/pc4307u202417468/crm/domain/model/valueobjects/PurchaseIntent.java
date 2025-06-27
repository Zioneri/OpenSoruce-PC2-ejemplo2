package com.zillow.platform.u202417468.pc4307u202417468.crm.domain.model.valueobjects;

import jakarta.persistence.Embeddable;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Embeddable
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class PurchaseIntent {
    private String locationPreference;

    private Integer minBedrooms;

    public PurchaseIntent(String locationPreference, Integer minBedrooms) {
        if (minBedrooms != null && minBedrooms < 1)
            throw new IllegalArgumentException("minBedrooms must be ≥ 1");
        this.locationPreference = (locationPreference != null && locationPreference.isBlank()) ? null
                : locationPreference;
        this.minBedrooms = minBedrooms;
    }
}
