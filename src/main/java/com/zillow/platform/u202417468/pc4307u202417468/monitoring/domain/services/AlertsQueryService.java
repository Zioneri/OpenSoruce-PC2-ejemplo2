package com.zillow.platform.u202417468.pc4307u202417468.monitoring.domain.services;

import java.util.List;

import com.zillow.platform.u202417468.pc4307u202417468.monitoring.domain.model.aggregates.Alerts;
import com.zillow.platform.u202417468.pc4307u202417468.monitoring.domain.model.queries.GetAllAlertsQuery;

/**
 * Domain service interface for alert query operations within the monitoring
 * bounded context.
 * Provides read-only access to alert data with query processing capabilities.
 * 
 * @author Fabrizzio Pereira – Code: U202417468
 */
public interface AlertsQueryService {
    /**
     * Retrieves all alerts from the monitoring system.
     * 
     * @param query the query specification for alert retrieval
     * @return List of all alerts in the system
     */
    List<Alerts> handle(GetAllAlertsQuery query);
}
