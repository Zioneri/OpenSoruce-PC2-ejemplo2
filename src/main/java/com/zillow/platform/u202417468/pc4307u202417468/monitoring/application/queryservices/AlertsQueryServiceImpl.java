package com.zillow.platform.u202417468.pc4307u202417468.monitoring.application.queryservices;

import java.util.List;

import org.springframework.stereotype.Service;

import com.zillow.platform.u202417468.pc4307u202417468.monitoring.domain.model.aggregates.Alerts;
import com.zillow.platform.u202417468.pc4307u202417468.monitoring.domain.model.queries.GetAllAlertsQuery;
import com.zillow.platform.u202417468.pc4307u202417468.monitoring.domain.services.AlertsQueryService;
import com.zillow.platform.u202417468.pc4307u202417468.monitoring.infrastructure.persistence.jpa.repositories.AlertsRepository;

@Service
public class AlertsQueryServiceImpl implements AlertsQueryService {
    private final AlertsRepository alertsRepository;

    public AlertsQueryServiceImpl(AlertsRepository alertsRepository) {
        this.alertsRepository = alertsRepository;
    }

    @Override
    public List<Alerts> handle(GetAllAlertsQuery query) {
        return alertsRepository.findAll();
    }
}
