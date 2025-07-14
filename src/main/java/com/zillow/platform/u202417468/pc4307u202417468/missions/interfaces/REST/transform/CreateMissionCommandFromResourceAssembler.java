package com.zillow.platform.u202417468.pc4307u202417468.missions.interfaces.REST.transform;

import com.zillow.platform.u202417468.pc4307u202417468.missions.domain.model.commands.CreateMissionAssignmentsCommand;
import com.zillow.platform.u202417468.pc4307u202417468.missions.interfaces.REST.resources.CreateMissionResource;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class CreateMissionCommandFromResourceAssembler {

    public static CreateMissionAssignmentsCommand toCommandFromResource(CreateMissionResource resource) {
        LocalDateTime requestedAt = LocalDateTime.parse(
                resource.requestedAt(),
                DateTimeFormatter.ISO_DATE_TIME);

        return new CreateMissionAssignmentsCommand(
                resource.satelliteCode(),
                resource.orbitClass(),
                resource.estimatedDuration(),
                resource.status(),
                requestedAt);
    }
}
