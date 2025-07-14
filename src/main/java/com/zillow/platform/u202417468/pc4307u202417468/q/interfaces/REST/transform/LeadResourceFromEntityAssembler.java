package com.zillow.platform.u202417468.pc4307u202417468.q.interfaces.REST.transform;

import com.zillow.platform.u202417468.pc4307u202417468.q.domain.model.aggregates.Lead;
import com.zillow.platform.u202417468.pc4307u202417468.q.interfaces.REST.resources.LeadResource;

public class LeadResourceFromEntityAssembler {
    public static LeadResource toResourceFromEntity(Lead entity) {
        return new LeadResource(
                entity.getId(),
                entity.getSellerId().getSellerId(),
                entity.getEmail().getEmail(),
                entity.getContactInfo().getFullName(),
                entity.getContactInfo().getPhone(),
                entity.getPersonalInfo().getAge(),
                entity.getPersonalInfo().getIncomeLevel(),
                entity.getPurchaseIntent().getLocationPreference(),
                entity.getPurchaseIntent().getMinBedrooms(),
                entity.getBudget().getAmount(),
                entity.getBudget().getCurrency(),
                entity.getSource().name(),
                entity.getStatus().name(),
                entity.getCreatedAt().toString(),
                entity.getUpdatedAt().toString());
    }
}
