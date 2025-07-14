package com.zillow.platform.u202417468.pc4307u202417468.missions.domain.model.aggregates;

import java.time.LocalDateTime;

import com.zillow.platform.u202417468.pc4307u202417468.missions.domain.model.valueobjects.EMissionAssignmentStatus;
import com.zillow.platform.u202417468.pc4307u202417468.missions.domain.model.valueobjects.SatelliteCode;
import com.zillow.platform.u202417468.pc4307u202417468.shared.domain.model.aggregates.AuditableAbstractAggregateRoot;

import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class MissionAssignments extends AuditableAbstractAggregateRoot<MissionAssignments> {
    @Embedded
    private SatelliteCode satelliteCode;

    @NotBlank(message = "orbitClass is required and must not be blank")
    private String orbitClass;

    @NotNull(message = "estimatedDuration is required")
    @Positive(message = "estimatedDuration must be a positive number")
    private Integer estimatedDuration;

    @NotNull(message = "status is required")
    @Enumerated(EnumType.STRING)
    private EMissionAssignmentStatus status;

    @NotNull(message = "requestedAt is required")
    private LocalDateTime requestedAt;
}
