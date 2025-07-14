package com.zillow.platform.u202417468.pc4307u202417468.missions.domain.services;

import java.util.Optional;

import com.zillow.platform.u202417468.pc4307u202417468.missions.domain.model.aggregates.MissionAssignments;
import com.zillow.platform.u202417468.pc4307u202417468.missions.domain.model.commands.CreateMissionAssignmentsCommand;

public interface MissionAssignmentsCommandService {
    Optional<MissionAssignments> handle(CreateMissionAssignmentsCommand command);

}
