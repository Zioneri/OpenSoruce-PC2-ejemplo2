package com.zillow.platform.u202417468.pc4307u202417468.monitoring.interfaces.REST.resources;

public record AlertResource(
        Long id,
        String satelliteCode,
        String alertType,
        String registeredAt,
        String createdAt,
        String updatedAt) {
}
