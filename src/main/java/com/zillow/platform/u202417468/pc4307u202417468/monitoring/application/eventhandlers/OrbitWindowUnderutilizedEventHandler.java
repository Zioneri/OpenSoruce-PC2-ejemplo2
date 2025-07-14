package com.zillow.platform.u202417468.pc4307u202417468.monitoring.application.eventhandlers;

import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

import com.zillow.platform.u202417468.pc4307u202417468.monitoring.domain.model.aggregates.Alerts;
import com.zillow.platform.u202417468.pc4307u202417468.monitoring.domain.model.commands.CreateAlertsCommand;
import com.zillow.platform.u202417468.pc4307u202417468.monitoring.domain.model.valueobjects.EAlertType;
import com.zillow.platform.u202417468.pc4307u202417468.monitoring.infrastructure.persistence.jpa.repositories.AlertsRepository;
import com.zillow.platform.u202417468.pc4307u202417468.shared.domain.model.events.OrbitWindowUnderutilizedEvent;

/**
 * Event handler for orbit window underutilization events within the monitoring
 * bounded context.
 * Processes underutilization notifications from the missions context and
 * automatically
 * creates system error alerts for monitoring and notification purposes.
 * 
 * @author Fabrizzio Pereira – Code: U202417468
 */
@Component
public class OrbitWindowUnderutilizedEventHandler {

    private final AlertsRepository alertsRepository;

    public OrbitWindowUnderutilizedEventHandler(AlertsRepository alertsRepository) {
        this.alertsRepository = alertsRepository;
    }

    /**
     * Handles orbit window underutilization events by creating automatic system
     * error alerts.
     * Converts mission underutilization events into monitoring alerts for
     * operational awareness.
     * 
     * @param event the orbit window underutilization event from missions context
     */
    @EventListener
    public void handleOrbitWindowUnderutilizedEvent(OrbitWindowUnderutilizedEvent event) {
        CreateAlertsCommand command = new CreateAlertsCommand(
                event.satelliteCode().toString(),
                EAlertType.SYSTEM_ERROR.name());
        Alerts alert = new Alerts(command);
        alertsRepository.save(alert);
    }
}
