package com.zillow.platform.u202417468.pc4307u202417468.regulations.infrastructure.persistence.jpa.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.zillow.platform.u202417468.pc4307u202417468.regulations.domain.model.aggregates.OrbitThresholds;

@Repository
public interface OrbitThresholdsRepository extends JpaRepository<OrbitThresholds, Long> {
    Optional<OrbitThresholds> findByOrbitClassIgnoreCase(String orbitClass);

    boolean existsByOrbitClassIgnoreCase(String orbitClass);
}
