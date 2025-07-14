package com.zillow.platform.u202417468.pc4307u202417468.missions.domain.model.commands;

import java.time.LocalDateTime;

/**
 * Command for creating new mission assignments in the missions bounded context.
 * Encapsulates all required data for mission assignment creation including
 * satellite identification,
 * orbital parameters, duration estimates, and scheduling information.
 * 
 * @param satelliteCode     the satellite identifier as a string (must be valid
 *                          UUID format)
 * @param orbitClass        the orbital class designation (LEO, MEO, GEO)
 * @param estimatedDuration the estimated mission duration in time units
 * @param status            the mission assignment status (SCHEDULED or
 *                          REJECTED)
 * @param requestedAt       the timestamp when the mission was requested
 * 
 * @author Fabrizzio Pereira – Code: U202417468
 */
public record CreateMissionAssignmentsCommand(
                String satelliteCode,
                String orbitClass,
                Integer estimatedDuration,
                String status,
                LocalDateTime requestedAt) {

}
