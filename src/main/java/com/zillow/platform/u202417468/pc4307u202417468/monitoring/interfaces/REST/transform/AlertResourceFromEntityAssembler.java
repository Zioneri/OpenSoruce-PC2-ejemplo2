package com.zillow.platform.u202417468.pc4307u202417468.monitoring.interfaces.REST.transform;

import com.zillow.platform.u202417468.pc4307u202417468.monitoring.domain.model.aggregates.Alerts;
import com.zillow.platform.u202417468.pc4307u202417468.monitoring.interfaces.REST.resources.AlertResource;

/**
 * Assembler for transforming alert entities into REST response resources.
 * Handles the conversion from monitoring domain entities to presentation layer
 * representations,
 * formatting alert data for API responses and client consumption.
 * 
 * @author Fabrizzio Pereira – Code: U202417468
 */
public class AlertResourceFromEntityAssembler {

    /**
     * Transforms an alert entity into a REST resource representation.
     * Converts domain data types to string representations suitable for JSON
     * serialization.
     * 
     * @param entity the alert domain entity
     * @return AlertResource formatted for REST API response
     */
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
