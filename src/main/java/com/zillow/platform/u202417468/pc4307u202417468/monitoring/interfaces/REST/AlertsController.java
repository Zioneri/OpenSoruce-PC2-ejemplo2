package com.zillow.platform.u202417468.pc4307u202417468.monitoring.interfaces.REST;

import java.util.List;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.zillow.platform.u202417468.pc4307u202417468.monitoring.domain.model.queries.GetAllAlertsQuery;
import com.zillow.platform.u202417468.pc4307u202417468.monitoring.domain.services.AlertsQueryService;
import com.zillow.platform.u202417468.pc4307u202417468.monitoring.interfaces.REST.resources.AlertResource;
import com.zillow.platform.u202417468.pc4307u202417468.monitoring.interfaces.REST.transform.AlertResourceFromEntityAssembler;

import io.swagger.v3.oas.annotations.tags.Tag;

/**
 * REST controller for alert operations within the monitoring bounded context.
 * Provides HTTP endpoints for alert retrieval and monitoring system access,
 * handling request processing and response formatting for alert data.
 * 
 * @author Fabrizzio Pereira – Code: U202417468
 */
@RestController
@RequestMapping(value = "/api/v1/alerts", produces = MediaType.APPLICATION_JSON_VALUE)
@Tag(name = "Alerts", description = "Alert Management Endpoints")
public class AlertsController {
    private final AlertsQueryService alertsQueryService;

    public AlertsController(AlertsQueryService alertsQueryService) {
        this.alertsQueryService = alertsQueryService;
    }

    /**
     * Retrieves all alerts from the monitoring system via HTTP GET request.
     * Provides comprehensive access to alert data for monitoring and analysis
     * purposes.
     * 
     * @return List of alert resources containing all system alerts
     */
    @GetMapping
    public List<AlertResource> getAllAlerts() {
        var query = new GetAllAlertsQuery();
        var alerts = alertsQueryService.handle(query);
        return alerts.stream()
                .map(AlertResourceFromEntityAssembler::toResourceFromEntity)
                .toList();
    }
}
