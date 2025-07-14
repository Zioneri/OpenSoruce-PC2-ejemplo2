package com.zillow.platform.u202417468.pc4307u202417468.missions.domain.model.commands;

import java.time.LocalDateTime;

public record CreateMissionAssignmentsCommand(
        String satelliteCode,
        String orbitClass,
        Integer estimatedDuration,
        String status,
        LocalDateTime requestedAt) {

}
