package com.zillow.platform.u202417468.pc4307u202417468.missions.interfaces.REST.transform;

import com.zillow.platform.u202417468.pc4307u202417468.missions.domain.model.aggregates.MissionAssignments;
import com.zillow.platform.u202417468.pc4307u202417468.missions.interfaces.REST.resources.MissionAssignmentResource;

public class MissionAssignmentResourceFromEntityAssembler {

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
