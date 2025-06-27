package com.zillow.platform.u202417468.pc4307u202417468.crm.interfaces.REST;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.zillow.platform.u202417468.pc4307u202417468.crm.domain.services.LeadCommandService;
import com.zillow.platform.u202417468.pc4307u202417468.crm.interfaces.REST.resources.CreateLeadResource;
import com.zillow.platform.u202417468.pc4307u202417468.crm.interfaces.REST.resources.LeadResource;
import com.zillow.platform.u202417468.pc4307u202417468.crm.interfaces.REST.transform.CreateLeadCommandFromResourceAssembler;
import com.zillow.platform.u202417468.pc4307u202417468.crm.interfaces.REST.transform.LeadResourceFromEntityAssembler;

import io.swagger.v3.oas.annotations.tags.Tag;

@RestController
@RequestMapping(value = "/api/v1/sellers/{sellerId}/leads", produces = MediaType.APPLICATION_JSON_VALUE)
@Tag(name = "Leads", description = "Lead Management Endpoints")
public class LeadController {
    private final LeadCommandService leadCommandService;

    public LeadController(LeadCommandService leadCommandService) {
        this.leadCommandService = leadCommandService;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<LeadResource> createLead(
            @PathVariable Long sellerId,
            @RequestBody CreateLeadResource resource) {

        var command = CreateLeadCommandFromResourceAssembler.toCommandFromResource(resource, sellerId);
        var lead = leadCommandService.handle(command);

        if (lead.isEmpty())
            return ResponseEntity.badRequest().build();

        var leadResource = LeadResourceFromEntityAssembler.toResourceFromEntity(lead.get());
        return new ResponseEntity<>(leadResource, HttpStatus.CREATED);
    }
}
