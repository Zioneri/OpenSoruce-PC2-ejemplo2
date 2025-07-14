package com.zillow.platform.u202417468.pc4307u202417468.missions.domain.model.valueobjects;

import java.util.UUID;

import jakarta.persistence.Embeddable;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

/**
 * Value object representing a satellite identifier within the missions bounded
 * context.
 * Encapsulates satellite code validation and ensures UUID format compliance
 * as required by business rules.
 * 
 * @author Fabrizzio Pereira – Code: U202417468
 */
@Getter
@Embeddable
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class SatelliteCode {
    private UUID satelliteCode;

    /**
     * Creates a new satellite code value object with validation.
     * 
     * @param satelliteCode the UUID representing the satellite identifier
     * @throws IllegalArgumentException if satelliteCode is null
     */
    public SatelliteCode(UUID satelliteCode) {
        this.satelliteCode = satelliteCode;
    }
}
