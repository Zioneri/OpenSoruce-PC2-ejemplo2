package com.zillow.platform.u202417468.pc4307u202417468.monitoring.domain.services;

import java.util.Optional;

import com.zillow.platform.u202417468.pc4307u202417468.monitoring.domain.model.aggregates.Alerts;
import com.zillow.platform.u202417468.pc4307u202417468.monitoring.domain.model.commands.CreateAlertsCommand;

/**
 * Domain service interface for alert command operations within the monitoring
 * bounded context.
 * Defines the contract for alert creation and management operations with
 * business validation.
 * 
 * @author Fabrizzio Pereira – Code: U202417468
 */
public interface AlertsCommandService {
    /**
     * Handles the creation of a new alert with validation and business rule
     * enforcement.
     * 
     * @param command the command containing alert creation data
     * @return Optional containing the created alert, or empty if creation failed
     */
    Optional<Alerts> handle(CreateAlertsCommand command);
}
