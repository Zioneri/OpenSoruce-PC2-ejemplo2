package com.zillow.platform.u202417468.pc4307u202417468.missions.application.outboundservices.acl;

import org.springframework.stereotype.Service;

import com.zillow.platform.u202417468.pc4307u202417468.monitoring.interfaces.acl.AlertsContextFacade;

@Service
public class ExternalAlertsService {
    private final AlertsContextFacade alertsContextFacade;

    public ExternalAlertsService(AlertsContextFacade alertsContextFacade) {
        this.alertsContextFacade = alertsContextFacade;
    }

    /**
     * Creates an alert through the ACL interface.
     * 
     * @param satelliteCode the satellite code
     * @param alertType     the type of alert
     * @return true if the alert was created successfully, false otherwise
     */
    public boolean createAlert(String satelliteCode, String alertType) {
        return alertsContextFacade.createAlert(satelliteCode, alertType);
    }
}
