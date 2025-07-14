package com.zillow.platform.u202417468.pc4307u202417468.missions.application.outboundservices.acl;

import org.springframework.stereotype.Service;

import com.zillow.platform.u202417468.pc4307u202417468.monitoring.interfaces.acl.AlertsContextFacade;

/**
 * External service for accessing alerts functionality through Anti-Corruption
 * Layer.
 * Provides the missions bounded context with capability to create alerts in the
 * monitoring context
 * while maintaining loose coupling between bounded contexts.
 * 
 * @author Fabrizzio Pereira – Code: U202417468
 */
@Service
public class ExternalAlertsService {
    private final AlertsContextFacade alertsContextFacade;

    public ExternalAlertsService(AlertsContextFacade alertsContextFacade) {
        this.alertsContextFacade = alertsContextFacade;
    }

    /**
     * Creates an alert in the monitoring context through the ACL interface.
     * Provides a clean abstraction for missions context to interact with monitoring
     * services.
     * 
     * @param satelliteCode the satellite identifier for the alert
     * @param alertType     the classification of the alert being created
     * @return true if the alert was created successfully, false otherwise
     */
    public boolean createAlert(String satelliteCode, String alertType) {
        return alertsContextFacade.createAlert(satelliteCode, alertType);
    }
}
