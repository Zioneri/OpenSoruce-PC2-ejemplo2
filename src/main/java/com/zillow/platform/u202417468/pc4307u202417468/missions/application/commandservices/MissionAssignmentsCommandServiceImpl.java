package com.zillow.platform.u202417468.pc4307u202417468.missions.application.commandservices;

import java.time.LocalDateTime;
import java.util.Optional;
import java.util.UUID;

import org.springframework.stereotype.Service;

import com.zillow.platform.u202417468.pc4307u202417468.missions.domain.model.aggregates.MissionAssignments;
import com.zillow.platform.u202417468.pc4307u202417468.missions.domain.model.commands.CreateMissionAssignmentsCommand;
import com.zillow.platform.u202417468.pc4307u202417468.missions.domain.services.MissionAssignmentsCommandService;
import com.zillow.platform.u202417468.pc4307u202417468.missions.infrastructure.persistence.jpa.repositories.MissionAssignmentsRepository;

@Service
public class MissionAssignmentsCommandServiceImpl implements MissionAssignmentsCommandService {
    private final MissionAssignmentsRepository missionAssignmentsRepository;

    public MissionAssignmentsCommandServiceImpl(MissionAssignmentsRepository missionAssignmentsRepository) {
        this.missionAssignmentsRepository = missionAssignmentsRepository;
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

        return Optional.of(mission);
    }

}
