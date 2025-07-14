package com.zillow.platform.u202417468.pc4307u202417468.missions.infrastructure.persistence.jpa.repositories;

import java.time.LocalDateTime;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.zillow.platform.u202417468.pc4307u202417468.missions.domain.model.aggregates.MissionAssignments;

/**
 * JPA repository for mission assignment persistence operations.
 * Provides data access methods for mission assignment entities including
 * specialized queries for business rule enforcement.
 * 
 * @author Fabrizzio Pereira – Code: U202417468
 */
@Repository
public interface MissionAssignmentsRepository extends JpaRepository<MissionAssignments, Long> {
    /**
     * Checks if a mission assignment exists for the given satellite code within a
     * specific date range.
     * Used to enforce the business rule of one assignment per satellite per day.
     * 
     * @param satelliteCode the satellite UUID identifier
     * @param startOfDay    the beginning of the target day
     * @param endOfDay      the end of the target day
     * @return true if a mission assignment exists for the satellite on the
     *         specified day
     */
    boolean existsBySatelliteCode_SatelliteCodeAndRequestedAtBetween(
            UUID satelliteCode,
            LocalDateTime startOfDay,
            LocalDateTime endOfDay);
}
