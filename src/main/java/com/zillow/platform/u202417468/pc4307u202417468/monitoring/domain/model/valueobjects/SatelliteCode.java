package com.zillow.platform.u202417468.pc4307u202417468.monitoring.domain.model.valueobjects;

import java.util.UUID;

import jakarta.persistence.Embeddable;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

/**
 * Value object representing a satellite identifier within the monitoring
 * bounded context.
 * Ensures satellite code validation and UUID format compliance for alert
 * tracking
 * and satellite monitoring operations.
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
        if (satelliteCode == null) {
            throw new IllegalArgumentException("satelliteCode cannot be null");
        }
        this.satelliteCode = satelliteCode;
    }
}
