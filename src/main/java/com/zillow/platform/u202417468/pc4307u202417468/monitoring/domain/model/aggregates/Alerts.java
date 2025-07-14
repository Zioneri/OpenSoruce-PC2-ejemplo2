package com.zillow.platform.u202417468.pc4307u202417468.monitoring.domain.model.aggregates;

import java.time.LocalDateTime;
import java.util.UUID;

import com.zillow.platform.u202417468.pc4307u202417468.monitoring.domain.model.commands.CreateAlertsCommand;
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

/**
 * Alert aggregate root representing system alerts within the monitoring bounded
 * context.
 * Encapsulates alert creation, type management, and satellite code validation
 * for
 * monitoring satellite operations and system events.
 * 
 * @author Fabrizzio Pereira – Code: U202417468
 */
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

    /**
     * Creates a new alert with validation of satellite code and alert type.
     * Automatically sets registration timestamp and validates business rules.
     * 
     * @param command the command containing alert creation data
     * @throws IllegalArgumentException if satellite code is invalid or alert type
     *                                  is unknown
     */
    public Alerts(CreateAlertsCommand command) {
        try {
            UUID uuid = UUID.fromString(command.satelliteCode());
            this.satelliteCode = new SatelliteCode(uuid);
        } catch (IllegalArgumentException ex) {
            throw new IllegalArgumentException("Invalid satelliteCode: must be a valid UUID string");
        }

        try {
            this.alertType = EAlertType.valueOf(command.alertType().toUpperCase());
        } catch (IllegalArgumentException ex) {
            throw new IllegalArgumentException(
                    "Invalid alertType: must be one of UNSAFE_ORBIT_TASK, NODE_COMMUNICATION_LOST, SYSTEM_ERROR, OTHER");
        }

        this.registeredAt = LocalDateTime.now();
    }
}
