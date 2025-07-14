package com.zillow.platform.u202417468.pc4307u202417468.monitoring.application.eventhandlers;

import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

import com.zillow.platform.u202417468.pc4307u202417468.monitoring.domain.model.aggregates.Alerts;
import com.zillow.platform.u202417468.pc4307u202417468.monitoring.domain.model.commands.CreateAlertsCommand;
import com.zillow.platform.u202417468.pc4307u202417468.monitoring.domain.model.valueobjects.EAlertType;
import com.zillow.platform.u202417468.pc4307u202417468.monitoring.infrastructure.persistence.jpa.repositories.AlertsRepository;
import com.zillow.platform.u202417468.pc4307u202417468.shared.domain.model.events.OrbitWindowUnderutilizedEvent;

@Component
public class OrbitWindowUnderutilizedEventHandler {

    private final AlertsRepository alertsRepository;

    public OrbitWindowUnderutilizedEventHandler(AlertsRepository alertsRepository) {
        this.alertsRepository = alertsRepository;
    }

    @EventListener
    public void handleOrbitWindowUnderutilizedEvent(OrbitWindowUnderutilizedEvent event) {
        CreateAlertsCommand command = new CreateAlertsCommand(
                event.satelliteCode().toString(),
                EAlertType.SYSTEM_ERROR.name());
        Alerts alert = new Alerts(command);
        alertsRepository.save(alert);
    }
}
