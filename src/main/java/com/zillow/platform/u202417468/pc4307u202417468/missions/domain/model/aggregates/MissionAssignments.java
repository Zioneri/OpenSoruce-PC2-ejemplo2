package com.zillow.platform.u202417468.pc4307u202417468.missions.domain.model.aggregates;

import java.time.LocalDateTime;
import java.util.UUID;

import com.zillow.platform.u202417468.pc4307u202417468.missions.domain.model.commands.CreateMissionAssignmentsCommand;
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

    public MissionAssignments(CreateMissionAssignmentsCommand command) {
        try {
            UUID uuid = UUID.fromString(command.satelliteCode());
            this.satelliteCode = new SatelliteCode(uuid);
        } catch (IllegalArgumentException ex) {
            throw new IllegalArgumentException("Invalid satelliteCode: must be a valid UUID string");
        }

        if (command.orbitClass() == null || command.orbitClass().isBlank()) {
            throw new IllegalArgumentException("orbitClass must not be null or blank");
        }
        this.orbitClass = command.orbitClass();
        if (command.estimatedDuration() == null || command.estimatedDuration() <= 0) {
            throw new IllegalArgumentException("estimatedDuration must be a positive number");
        }
        this.estimatedDuration = command.estimatedDuration();

        try {
            this.status = EMissionAssignmentStatus.valueOf(command.status().toUpperCase());
        } catch (IllegalArgumentException ex) {
            throw new IllegalArgumentException("Invalid status: must be SCHEDULED or REJECTED");
        }

        if (command.requestedAt() == null) {
            throw new IllegalArgumentException("requestedAt must not be null");
        }
        if (command.requestedAt().isAfter(LocalDateTime.now())) {
            throw new IllegalArgumentException("requestedAt must not be in the future");
        }

        this.requestedAt = command.requestedAt();
    }
}
