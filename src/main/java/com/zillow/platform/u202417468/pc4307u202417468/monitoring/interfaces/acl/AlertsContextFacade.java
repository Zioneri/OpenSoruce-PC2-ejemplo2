package com.zillow.platform.u202417468.pc4307u202417468.monitoring.interfaces.acl;

import org.springframework.stereotype.Service;

import com.zillow.platform.u202417468.pc4307u202417468.monitoring.domain.model.commands.CreateAlertsCommand;
import com.zillow.platform.u202417468.pc4307u202417468.monitoring.domain.services.AlertsCommandService;

/**
 * Anti-Corruption Layer facade for the monitoring bounded context.
 * Provides controlled access to alert creation functionality for external
 * bounded contexts,
 * specifically enabling the missions context to create alerts while maintaining
 * loose coupling.
 * 
 * @author Fabrizzio Pereira – Code: U202417468
 */
@Service
public class AlertsContextFacade {
    private final AlertsCommandService alertsCommandService;

    public AlertsContextFacade(AlertsCommandService alertsCommandService) {
        this.alertsCommandService = alertsCommandService;
    }

    /**
     * Creates a new alert through the Anti-Corruption Layer interface.
     * Provides external bounded contexts with controlled access to alert creation
     * while protecting the monitoring context's internal implementation.
     * 
     * @param satelliteCode the satellite identifier as a string (must be valid UUID
     *                      format)
     * @param alertType     the classification of alert to create
     * @return true if the alert was created successfully, false otherwise
     */
    public boolean createAlert(String satelliteCode, String alertType) {
        try {
            CreateAlertsCommand command = new CreateAlertsCommand(satelliteCode, alertType);
            var result = alertsCommandService.handle(command);
            return result.isPresent();
        } catch (Exception e) {
            // Log the exception in a real application
            return false;
        }
    }
}
