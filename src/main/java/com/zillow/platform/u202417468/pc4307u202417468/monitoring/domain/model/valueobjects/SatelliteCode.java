package com.zillow.platform.u202417468.pc4307u202417468.monitoring.domain.model.valueobjects;

import java.util.UUID;

import jakarta.persistence.Embeddable;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Embeddable
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class SatelliteCode {
    private UUID satelliteCode;

    public SatelliteCode(UUID satelliteCode) {
        if (satelliteCode == null) {
            throw new IllegalArgumentException("satelliteCode cannot be null");
        }
        this.satelliteCode = satelliteCode;
    }
}
