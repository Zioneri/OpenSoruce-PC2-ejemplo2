package com.zillow.platform.u202417468.pc4307u202417468.q.application.commandservices;

import java.util.Optional;

import org.springframework.stereotype.Service;

import com.zillow.platform.u202417468.pc4307u202417468.q.domain.model.aggregates.Lead;
import com.zillow.platform.u202417468.pc4307u202417468.q.domain.model.commands.CreateLeadCommand;
import com.zillow.platform.u202417468.pc4307u202417468.q.domain.model.valueobjects.ELeadSource;
import com.zillow.platform.u202417468.pc4307u202417468.q.domain.services.LeadCommandService;
import com.zillow.platform.u202417468.pc4307u202417468.q.infrastructure.persistence.jpa.repositories.LeadRepository;

@Service
public class LeadCommandServiceImpl implements LeadCommandService {
    private final LeadRepository leadRepository;

    public LeadCommandServiceImpl(LeadRepository leadRepository) {
        this.leadRepository = leadRepository;
    }

    @Override
    public Optional<Lead> handle(CreateLeadCommand command) {
        ELeadSource sourceEnum = ELeadSource.fromName(command.source());

        boolean exists = leadRepository
                .existsBySellerId_SellerIdAndEmail_EmailIgnoreCaseAndSource(
                        command.sellerId(),
                        command.email(),
                        sourceEnum);

        if (exists) {
            throw new IllegalStateException(
                    "Lead already registered for this seller, email and source");
        }

        var lead = new Lead(command);
        var createdLead = leadRepository.save(lead);
        return Optional.of(createdLead);
    }

}
