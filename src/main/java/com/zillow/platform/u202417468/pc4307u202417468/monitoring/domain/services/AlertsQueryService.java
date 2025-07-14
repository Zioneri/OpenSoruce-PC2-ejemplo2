package com.zillow.platform.u202417468.pc4307u202417468.monitoring.domain.services;

import java.util.List;

import com.zillow.platform.u202417468.pc4307u202417468.monitoring.domain.model.aggregates.Alerts;
import com.zillow.platform.u202417468.pc4307u202417468.monitoring.domain.model.queries.GetAllAlertsQuery;

public interface AlertsQueryService {
    List<Alerts> handle(GetAllAlertsQuery query);
}
