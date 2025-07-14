package com.zillow.platform.u202417468.pc4307u202417468.missions.domain.services;

import java.util.Optional;

import com.zillow.platform.u202417468.pc4307u202417468.missions.domain.model.aggregates.MissionAssignments;
import com.zillow.platform.u202417468.pc4307u202417468.missions.domain.model.commands.CreateMissionAssignmentsCommand;

/**
 * Domain service interface for mission assignment command operations.
 * Defines the contract for mission assignment creation and business rule
 * enforcement
 * within the missions bounded context.
 * 
 * @author Fabrizzio Pereira – Code: U202417468
 */
public interface MissionAssignmentsCommandService {
    /**
     * Handles the creation of a new mission assignment with full business
     * validation.
     * 
     * @param command the command containing mission assignment data
     * @return Optional containing the created mission assignment, or empty if
     *         creation failed
     */
    Optional<MissionAssignments> handle(CreateMissionAssignmentsCommand command);

}
