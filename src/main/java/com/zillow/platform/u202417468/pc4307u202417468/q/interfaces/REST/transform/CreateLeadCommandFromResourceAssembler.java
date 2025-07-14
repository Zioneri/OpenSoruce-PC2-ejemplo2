package com.zillow.platform.u202417468.pc4307u202417468.q.interfaces.REST.transform;

import com.zillow.platform.u202417468.pc4307u202417468.q.domain.model.commands.CreateLeadCommand;
import com.zillow.platform.u202417468.pc4307u202417468.q.interfaces.REST.resources.CreateLeadResource;

public class CreateLeadCommandFromResourceAssembler {
    public static CreateLeadCommand toCommandFromResource(CreateLeadResource resource,
            Long sellerId) {
        return new CreateLeadCommand(
                sellerId,
                resource.email(),
                resource.fullName(),
                resource.phone(),
                resource.age(),
                resource.incomeLevel(),
                resource.locationPreference(),
                resource.minBedrooms(),
                resource.budgetAmount(),
                resource.budgetCurrency(),
                resource.source());
    }
}
