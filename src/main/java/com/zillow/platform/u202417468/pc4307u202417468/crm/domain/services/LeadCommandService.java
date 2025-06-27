package com.zillow.platform.u202417468.pc4307u202417468.crm.domain.services;

import java.util.Optional;

import com.zillow.platform.u202417468.pc4307u202417468.crm.domain.model.aggregates.Lead;
import com.zillow.platform.u202417468.pc4307u202417468.crm.domain.model.commands.CreateLeadCommand;

public interface LeadCommandService {
    Optional<Lead> handle(CreateLeadCommand command);
}
