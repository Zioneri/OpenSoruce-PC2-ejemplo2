package com.zillow.platform.u202417468.pc4307u202417468.monitoring.interfaces.REST.transform;

import com.zillow.platform.u202417468.pc4307u202417468.monitoring.domain.model.aggregates.Alerts;
import com.zillow.platform.u202417468.pc4307u202417468.monitoring.interfaces.REST.resources.AlertResource;

public class AlertResourceFromEntityAssembler {

    public static AlertResource toResourceFromEntity(Alerts entity) {
        return new AlertResource(
                entity.getId(),
                entity.getSatelliteCode().getSatelliteCode().toString(),
                entity.getAlertType().name(),
                entity.getRegisteredAt().toString(),
                entity.getCreatedAt().toString(),
                entity.getUpdatedAt().toString());
    }
}
