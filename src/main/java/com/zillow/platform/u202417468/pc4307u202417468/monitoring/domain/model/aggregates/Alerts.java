package com.zillow.platform.u202417468.pc4307u202417468.monitoring.domain.model.aggregates;

import java.time.LocalDateTime;

import com.zillow.platform.u202417468.pc4307u202417468.monitoring.domain.model.valueobjects.EAlertType;
import com.zillow.platform.u202417468.pc4307u202417468.monitoring.domain.model.valueobjects.SatelliteCode;
import com.zillow.platform.u202417468.pc4307u202417468.shared.domain.model.aggregates.AuditableAbstractAggregateRoot;

import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.validation.constraints.NotNull;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Alerts extends AuditableAbstractAggregateRoot<Alerts> {
    @Embedded
    private SatelliteCode satelliteCode;

    @NotNull(message = "alertType is required")
    @Enumerated(EnumType.STRING)
    private EAlertType alertType;

    private LocalDateTime registeredAt;
}
