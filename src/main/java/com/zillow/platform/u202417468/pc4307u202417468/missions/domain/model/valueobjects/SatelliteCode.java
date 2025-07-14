package com.zillow.platform.u202417468.pc4307u202417468.missions.domain.model.valueobjects;

import java.util.UUID;

import jakarta.persistence.Embeddable;
import lombok.Getter;

@Getter
@Embeddable
public class SatelliteCode {
    private UUID satelliteCode;

    public SatelliteCode() {
        this.satelliteCode = UUID.randomUUID();
    }
}
