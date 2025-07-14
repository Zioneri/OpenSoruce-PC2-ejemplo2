package com.zillow.platform.u202417468.pc4307u202417468.monitoring.domain.services;

import java.util.Optional;

import com.zillow.platform.u202417468.pc4307u202417468.monitoring.domain.model.aggregates.Alerts;
import com.zillow.platform.u202417468.pc4307u202417468.monitoring.domain.model.commands.CreateAlertsCommand;

public interface AlertsCommandService {
    Optional<Alerts> handle(CreateAlertsCommand command);
}
