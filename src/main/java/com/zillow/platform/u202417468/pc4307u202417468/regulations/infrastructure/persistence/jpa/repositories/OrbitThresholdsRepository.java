package com.zillow.platform.u202417468.pc4307u202417468.regulations.infrastructure.persistence.jpa.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.zillow.platform.u202417468.pc4307u202417468.regulations.domain.model.aggregates.OrbitThresholds;

/**
 * JPA repository for orbit threshold persistence operations within the
 * regulations bounded context.
 * Provides data access methods for orbital safety regulations including
 * specialized queries
 * for orbital class validation and threshold retrieval.
 * 
 * @author Fabrizzio Pereira – Code: U202417468
 */
@Repository
public interface OrbitThresholdsRepository extends JpaRepository<OrbitThresholds, Long> {
    /**
     * Finds orbit threshold by orbital class designation with case-insensitive
     * matching.
     * Used for retrieving safety regulations for specific orbital classifications.
     * 
     * @param orbitClass the orbital class to search for (case-insensitive)
     * @return Optional containing the orbit threshold if found
     */
    Optional<OrbitThresholds> findByOrbitClassIgnoreCase(String orbitClass);

    /**
     * Checks if an orbit threshold exists for the specified orbital class with
     * case-insensitive matching.
     * Used for validating orbital class existence in business rule enforcement.
     * 
     * @param orbitClass the orbital class to validate (case-insensitive)
     * @return true if the orbital class exists in regulations
     */
    boolean existsByOrbitClassIgnoreCase(String orbitClass);
}
