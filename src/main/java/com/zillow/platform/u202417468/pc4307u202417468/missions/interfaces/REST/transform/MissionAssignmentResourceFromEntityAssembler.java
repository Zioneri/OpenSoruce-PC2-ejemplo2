package com.zillow.platform.u202417468.pc4307u202417468.missions.interfaces.REST.transform;

import com.zillow.platform.u202417468.pc4307u202417468.missions.domain.model.aggregates.MissionAssignments;
import com.zillow.platform.u202417468.pc4307u202417468.missions.interfaces.REST.resources.MissionAssignmentResource;

/**
 * Assembler for transforming mission assignment entities into REST response
 * resources.
 * Handles the conversion from domain entities to presentation layer
 * representations,
 * formatting data for API responses and client consumption.
 * 
 * @author Fabrizzio Pereira – Code: U202417468
 */
public class MissionAssignmentResourceFromEntityAssembler {

    /**
     * Transforms a mission assignment entity into a REST resource representation.
     * Converts domain data types to string representations suitable for JSON
     * serialization.
     * 
     * @param entity the mission assignment domain entity
     * @return MissionAssignmentResource formatted for REST API response
     */
    public static MissionAssignmentResource toResourceFromEntity(MissionAssignments entity) {
        return new MissionAssignmentResource(
                entity.getId(),
                entity.getSatelliteCode().getSatelliteCode().toString(),
                entity.getOrbitClass(),
                entity.getEstimatedDuration(),
                entity.getStatus().name(),
                entity.getRequestedAt().toString(),
                entity.getCreatedAt().toString(),
                entity.getUpdatedAt().toString());
    }
}
