package com.zillow.platform.u202417468.pc4307u202417468.missions.interfaces.REST;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.zillow.platform.u202417468.pc4307u202417468.missions.domain.services.MissionAssignmentsCommandService;
import com.zillow.platform.u202417468.pc4307u202417468.missions.interfaces.REST.resources.CreateMissionResource;
import com.zillow.platform.u202417468.pc4307u202417468.missions.interfaces.REST.resources.MissionAssignmentResource;
import com.zillow.platform.u202417468.pc4307u202417468.missions.interfaces.REST.transform.CreateMissionCommandFromResourceAssembler;
import com.zillow.platform.u202417468.pc4307u202417468.missions.interfaces.REST.transform.MissionAssignmentResourceFromEntityAssembler;

import io.swagger.v3.oas.annotations.tags.Tag;

/**
 * REST controller for mission assignment operations within the missions bounded
 * context.
 * Provides HTTP endpoints for mission assignment creation and management,
 * handling request/response transformation and HTTP status management.
 * 
 * @author Fabrizzio Pereira – Code: U202417468
 */
@RestController
@RequestMapping(value = "/api/v1/mission-assignments", produces = MediaType.APPLICATION_JSON_VALUE)
@Tag(name = "Mission Assignments", description = "Mission Assignment Management Endpoints")
public class MissionAssignmentsController {
    private final MissionAssignmentsCommandService missionAssignmentsCommandService;

    public MissionAssignmentsController(MissionAssignmentsCommandService missionAssignmentsCommandService) {
        this.missionAssignmentsCommandService = missionAssignmentsCommandService;
    }

    /**
     * Creates a new mission assignment through HTTP POST request.
     * Validates input data, processes business rules, and returns appropriate HTTP
     * responses.
     * 
     * @param resource the mission assignment creation request data
     * @return ResponseEntity containing the created mission assignment or error
     *         status
     */
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<MissionAssignmentResource> createMission(
            @RequestBody CreateMissionResource resource) {
        var command = CreateMissionCommandFromResourceAssembler.toCommandFromResource(resource);
        var missionAssignment = missionAssignmentsCommandService.handle(command);

        if (missionAssignment.isEmpty())
            return ResponseEntity.badRequest().build();

        var missionAssignmentResource = MissionAssignmentResourceFromEntityAssembler
                .toResourceFromEntity(missionAssignment.get());
        return new ResponseEntity<>(missionAssignmentResource, HttpStatus.CREATED);
    }
}
