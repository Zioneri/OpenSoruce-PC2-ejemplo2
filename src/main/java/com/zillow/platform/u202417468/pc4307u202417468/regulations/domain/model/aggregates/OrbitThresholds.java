package com.zillow.platform.u202417468.pc4307u202417468.regulations.domain.model.aggregates;

import com.zillow.platform.u202417468.pc4307u202417468.shared.domain.model.aggregates.AuditableAbstractAggregateRoot;

import jakarta.persistence.Entity;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

/**
 * Orbit Threshold aggregate root representing orbital safety regulations within
 * the regulations bounded context.
 * Defines maximum safe operation durations for different orbital classes and
 * enforces
 * safety constraints for satellite mission planning and execution.
 * 
 * @author Fabrizzio Pereira – Code: U202417468
 */
@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class OrbitThresholds extends AuditableAbstractAggregateRoot<OrbitThresholds> {
    @NotBlank(message = "orbitClass is required and must not be blank")
    private String orbitClass;

    @NotNull(message = "maxSafeDuration is required")
    @Positive(message = "maxSafeDuration must be a positive number")
    private Integer maxSafeDuration;

    /**
     * Creates a new orbit threshold with validation of orbital class and safety
     * duration.
     * Enforces business rules for valid orbital classifications and positive safety
     * durations.
     * 
     * @param orbitClass      the orbital class designation (LEO, MEO, GEO)
     * @param maxSafeDuration the maximum safe operational duration for the orbital
     *                        class
     * @throws IllegalArgumentException if validation rules are violated
     */
    public OrbitThresholds(String orbitClass, Integer maxSafeDuration) {
        if (orbitClass == null || orbitClass.isBlank()) {
            throw new IllegalArgumentException("orbitClass cannot be null or blank");
        }
        if (maxSafeDuration == null || maxSafeDuration <= 0) {
            throw new IllegalArgumentException("maxSafeDuration must be positive");
        }
        this.orbitClass = orbitClass;
        this.maxSafeDuration = maxSafeDuration;
    }
}
