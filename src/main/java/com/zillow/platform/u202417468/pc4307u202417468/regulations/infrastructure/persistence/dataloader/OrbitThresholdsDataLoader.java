package com.zillow.platform.u202417468.pc4307u202417468.regulations.infrastructure.persistence.dataloader;

import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

import com.zillow.platform.u202417468.pc4307u202417468.regulations.domain.model.aggregates.OrbitThresholds;
import com.zillow.platform.u202417468.pc4307u202417468.regulations.infrastructure.persistence.jpa.repositories.OrbitThresholdsRepository;

/**
 * Data loader for initializing orbit threshold regulations on application
 * startup.
 * Automatically populates the regulations database with standard orbital safety
 * thresholds
 * as required by business specifications for LEO, MEO, and GEO orbital classes.
 * 
 * @author Fabrizzio Pereira – Code: U202417468
 */
@Component
public class OrbitThresholdsDataLoader {

    private final OrbitThresholdsRepository orbitThresholdsRepository;

    public OrbitThresholdsDataLoader(OrbitThresholdsRepository orbitThresholdsRepository) {
        this.orbitThresholdsRepository = orbitThresholdsRepository;
    }

    /**
     * Loads orbit threshold data when the application is ready.
     * Initializes the database with standard orbital safety regulations if not
     * already present.
     * Creates thresholds for LEO (300), MEO (450), and GEO (600) orbital classes.
     */
    @EventListener(ApplicationReadyEvent.class)
    public void loadOrbitThresholdsData() {
        if (orbitThresholdsRepository.count() == 0) {
            orbitThresholdsRepository.save(new OrbitThresholds("LEO", 300));
            orbitThresholdsRepository.save(new OrbitThresholds("MEO", 450));
            orbitThresholdsRepository.save(new OrbitThresholds("GEO", 600));
        }
    }
}
