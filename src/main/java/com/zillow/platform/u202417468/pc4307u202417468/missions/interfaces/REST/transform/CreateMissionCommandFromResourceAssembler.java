package com.zillow.platform.u202417468.pc4307u202417468.missions.interfaces.REST.transform;

import com.zillow.platform.u202417468.pc4307u202417468.missions.domain.model.commands.CreateMissionAssignmentsCommand;
import com.zillow.platform.u202417468.pc4307u202417468.missions.interfaces.REST.resources.CreateMissionResource;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * Assembler for transforming REST resources into domain commands for mission
 * assignment creation.
 * Implements the transformation logic between the presentation layer and domain
 * layer,
 * handling data format conversion and validation preparation.
 * 
 * @author Fabrizzio Pereira – Code: U202417468
 */
public class CreateMissionCommandFromResourceAssembler {

    /**
     * Transforms a mission creation resource into a domain command.
     * Handles date/time parsing and data structure conversion for domain
     * processing.
     * 
     * @param resource the REST resource containing mission assignment data
     * @return CreateMissionAssignmentsCommand ready for domain processing
     */
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
