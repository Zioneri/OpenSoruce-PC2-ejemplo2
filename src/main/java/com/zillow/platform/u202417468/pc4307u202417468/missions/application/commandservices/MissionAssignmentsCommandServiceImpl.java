package com.zillow.platform.u202417468.pc4307u202417468.missions.application.commandservices;

import java.time.LocalDateTime;
import java.util.Optional;
import java.util.UUID;

import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Service;

import com.zillow.platform.u202417468.pc4307u202417468.missions.domain.model.aggregates.MissionAssignments;
import com.zillow.platform.u202417468.pc4307u202417468.missions.domain.model.commands.CreateMissionAssignmentsCommand;
import com.zillow.platform.u202417468.pc4307u202417468.missions.domain.services.MissionAssignmentsCommandService;
import com.zillow.platform.u202417468.pc4307u202417468.missions.infrastructure.persistence.jpa.repositories.MissionAssignmentsRepository;
import com.zillow.platform.u202417468.pc4307u202417468.regulations.infrastructure.persistence.jpa.repositories.OrbitThresholdsRepository;
import com.zillow.platform.u202417468.pc4307u202417468.shared.domain.model.events.OrbitWindowUnderutilizedEvent;

@Service
public class MissionAssignmentsCommandServiceImpl implements MissionAssignmentsCommandService {
    private final MissionAssignmentsRepository missionAssignmentsRepository;
    private final OrbitThresholdsRepository orbitThresholdsRepository;
    private final ApplicationEventPublisher eventPublisher;

    public MissionAssignmentsCommandServiceImpl(
            MissionAssignmentsRepository missionAssignmentsRepository,
            OrbitThresholdsRepository orbitThresholdsRepository,
            ApplicationEventPublisher eventPublisher) {
        this.missionAssignmentsRepository = missionAssignmentsRepository;
        this.orbitThresholdsRepository = orbitThresholdsRepository;
        this.eventPublisher = eventPublisher;
    }

    @Override
    public Optional<MissionAssignments> handle(CreateMissionAssignmentsCommand command) {
        UUID uuid = UUID.fromString(command.satelliteCode());

        LocalDateTime startOfDay = command.requestedAt().toLocalDate().atStartOfDay();
        LocalDateTime endOfDay = startOfDay.plusDays(1).minusNanos(1);

        boolean exists = missionAssignmentsRepository
                .existsBySatelliteCode_SatelliteCodeAndRequestedAtBetween(uuid, startOfDay, endOfDay);

        if (exists) {
            return Optional.empty();
        }

        MissionAssignments mission = new MissionAssignments(command);
        missionAssignmentsRepository.save(mission);

        checkForSuboptimalUtilization(mission);

        return Optional.of(mission);
    }

    private void checkForSuboptimalUtilization(MissionAssignments mission) {
        var orbitThreshold = orbitThresholdsRepository.findByOrbitClassIgnoreCase(mission.getOrbitClass());

        if (orbitThreshold.isPresent()) {
            Integer maxSafeDuration = orbitThreshold.get().getMaxSafeDuration();
            Integer estimatedDuration = mission.getEstimatedDuration();

            double twentyPercentThreshold = maxSafeDuration * 0.20;

            if (estimatedDuration < twentyPercentThreshold) {
                double utilizationPercentage = (estimatedDuration.doubleValue() / maxSafeDuration) * 100;

                OrbitWindowUnderutilizedEvent event = new OrbitWindowUnderutilizedEvent(
                        mission.getSatelliteCode().getSatelliteCode(),
                        mission.getOrbitClass(),
                        estimatedDuration,
                        maxSafeDuration,
                        utilizationPercentage);

                eventPublisher.publishEvent(event);
            }
        }
    }
}
