package com.zillow.platform.u202417468.pc4307u202417468.monitoring.application.commandservices;

import java.util.Optional;

import org.springframework.stereotype.Service;

import com.zillow.platform.u202417468.pc4307u202417468.monitoring.domain.model.aggregates.Alerts;
import com.zillow.platform.u202417468.pc4307u202417468.monitoring.domain.model.commands.CreateAlertsCommand;
import com.zillow.platform.u202417468.pc4307u202417468.monitoring.domain.services.AlertsCommandService;
import com.zillow.platform.u202417468.pc4307u202417468.monitoring.infrastructure.persistence.jpa.repositories.AlertsRepository;

@Service
public class AlertsCommandServiceImpl implements AlertsCommandService {
    private final AlertsRepository alertsRepository;

    public AlertsCommandServiceImpl(AlertsRepository alertsRepository) {
        this.alertsRepository = alertsRepository;
    }

    @Override
    public Optional<Alerts> handle(CreateAlertsCommand command) {
        Alerts alert = new Alerts(command);
        alertsRepository.save(alert);

        return Optional.of(alert);
    }

}
