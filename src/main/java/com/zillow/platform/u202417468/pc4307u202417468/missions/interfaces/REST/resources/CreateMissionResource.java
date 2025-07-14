package com.zillow.platform.u202417468.pc4307u202417468.missions.interfaces.REST.resources;

public record CreateMissionResource(
        String satelliteCode,
        String orbitClass,
        Integer estimatedDuration,
        String status,
        String requestedAt) {
}
