package com.zillow.platform.u202417468.pc4307u202417468.regulations.infrastructure.persistence.dataloader;

import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

import com.zillow.platform.u202417468.pc4307u202417468.regulations.domain.model.aggregates.OrbitThresholds;
import com.zillow.platform.u202417468.pc4307u202417468.regulations.infrastructure.persistence.jpa.repositories.OrbitThresholdsRepository;

@Component
public class OrbitThresholdsDataLoader {

    private final OrbitThresholdsRepository orbitThresholdsRepository;

    public OrbitThresholdsDataLoader(OrbitThresholdsRepository orbitThresholdsRepository) {
        this.orbitThresholdsRepository = orbitThresholdsRepository;
    }

    @EventListener(ApplicationReadyEvent.class)
    public void loadOrbitThresholdsData() {
        if (orbitThresholdsRepository.count() == 0) {
            orbitThresholdsRepository.save(new OrbitThresholds("LEO", 300));
            orbitThresholdsRepository.save(new OrbitThresholds("MEO", 450));
            orbitThresholdsRepository.save(new OrbitThresholds("GEO", 600));
        }
    }
}
