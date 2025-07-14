package com.zillow.platform.u202417468.pc4307u202417468.monitoring.infrastructure.persistence.jpa.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.zillow.platform.u202417468.pc4307u202417468.monitoring.domain.model.aggregates.Alerts;

/**
 * JPA repository for alert persistence operations within the monitoring bounded
 * context.
 * Provides data access methods for alert entities with standard CRUD operations
 * and potential for specialized alert queries.
 * 
 * @author Fabrizzio Pereira – Code: U202417468
 */
@Repository
public interface AlertsRepository extends JpaRepository<Alerts, Long> {
}
