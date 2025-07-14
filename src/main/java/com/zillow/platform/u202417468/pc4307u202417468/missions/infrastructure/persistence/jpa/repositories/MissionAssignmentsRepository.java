package com.zillow.platform.u202417468.pc4307u202417468.missions.infrastructure.persistence.jpa.repositories;

import java.time.LocalDateTime;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.zillow.platform.u202417468.pc4307u202417468.missions.domain.model.aggregates.MissionAssignments;

@Repository
public interface MissionAssignmentsRepository extends JpaRepository<MissionAssignments, Long> {
    boolean existsBySatelliteCode_SatelliteCodeAndRequestedAtBetween(
            UUID satelliteCode,
            LocalDateTime startOfDay,
            LocalDateTime endOfDay);
}
