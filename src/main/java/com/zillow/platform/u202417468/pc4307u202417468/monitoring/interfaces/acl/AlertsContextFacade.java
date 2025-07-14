package com.zillow.platform.u202417468.pc4307u202417468.monitoring.interfaces.acl;

import org.springframework.stereotype.Service;

import com.zillow.platform.u202417468.pc4307u202417468.monitoring.domain.model.commands.CreateAlertsCommand;
import com.zillow.platform.u202417468.pc4307u202417468.monitoring.domain.services.AlertsCommandService;

@Service
public class AlertsContextFacade {
    private final AlertsCommandService alertsCommandService;

    public AlertsContextFacade(AlertsCommandService alertsCommandService) {
        this.alertsCommandService = alertsCommandService;
    }

    /**
     * Creates a new alert through the ACL interface.
     * 
     * @param satelliteCode the satellite code as a string (must be a valid UUID)
     * @param alertType     the type of alert to create
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
