package com.zillow.platform.u202417468.pc4307u202417468.monitoring.infrastructure.persistence.jpa.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.zillow.platform.u202417468.pc4307u202417468.monitoring.domain.model.aggregates.Alerts;

@Repository
public interface AlertsRepository extends JpaRepository<Alerts, Long> {
}
