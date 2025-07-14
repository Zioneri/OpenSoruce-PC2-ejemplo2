package com.zillow.platform.u202417468.pc4307u202417468.monitoring.application.queryservices;

import java.util.List;

import org.springframework.stereotype.Service;

import com.zillow.platform.u202417468.pc4307u202417468.monitoring.domain.model.aggregates.Alerts;
import com.zillow.platform.u202417468.pc4307u202417468.monitoring.domain.model.queries.GetAllAlertsQuery;
import com.zillow.platform.u202417468.pc4307u202417468.monitoring.domain.services.AlertsQueryService;
import com.zillow.platform.u202417468.pc4307u202417468.monitoring.infrastructure.persistence.jpa.repositories.AlertsRepository;

/**
 * Implementation of alerts query service providing read access to alert data.
 * Handles alert retrieval operations and query processing within the monitoring
 * context.
 * 
 * @author Fabrizzio Pereira – Code: U202417468
 */
@Service
public class AlertsQueryServiceImpl implements AlertsQueryService {
    private final AlertsRepository alertsRepository;

    public AlertsQueryServiceImpl(AlertsRepository alertsRepository) {
        this.alertsRepository = alertsRepository;
    }

    /**
     * Retrieves all alerts from the monitoring system.
     * Provides comprehensive access to all stored alert records.
     * 
     * @param query the query specification (parameterless for all alerts)
     * @return List of all alerts in the system
     */
    @Override
    public List<Alerts> handle(GetAllAlertsQuery query) {
        return alertsRepository.findAll();
    }
}
