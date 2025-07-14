package com.zillow.platform.u202417468.pc4307u202417468.regulations.domain.model.aggregates;

import com.zillow.platform.u202417468.pc4307u202417468.shared.domain.model.aggregates.AuditableAbstractAggregateRoot;

import jakarta.persistence.Entity;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class OrbitThresholds extends AuditableAbstractAggregateRoot<OrbitThresholds> {
    @NotBlank(message = "orbitClass is required and must not be blank")
    private String orbitClass;

    @NotNull(message = "maxSafeDuration is required")
    @Positive(message = "maxSafeDuration must be a positive number")
    private Integer maxSafeDuration;

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
