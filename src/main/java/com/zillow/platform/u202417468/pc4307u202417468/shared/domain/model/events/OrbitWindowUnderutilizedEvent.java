package com.zillow.platform.u202417468.pc4307u202417468.shared.domain.model.events;

import java.util.UUID;

/**
 * Domain event fired when a mission assignment has a duration
 * less than 20% of the maximum safe duration for its orbit class,
 * indicating suboptimal use of the satellite node.
 */
public record OrbitWindowUnderutilizedEvent(
        UUID satelliteCode,
        String orbitClass,
        Integer estimatedDuration,
        Integer maxSafeDuration,
        double utilizationPercentage) {

    public OrbitWindowUnderutilizedEvent {
        if (satelliteCode == null) {
            throw new IllegalArgumentException("satelliteCode cannot be null");
        }
        if (orbitClass == null || orbitClass.isBlank()) {
            throw new IllegalArgumentException("orbitClass cannot be null or blank");
        }
        if (estimatedDuration == null || estimatedDuration <= 0) {
            throw new IllegalArgumentException("estimatedDuration must be positive");
        }
        if (maxSafeDuration == null || maxSafeDuration <= 0) {
            throw new IllegalArgumentException("maxSafeDuration must be positive");
        }
    }
}
