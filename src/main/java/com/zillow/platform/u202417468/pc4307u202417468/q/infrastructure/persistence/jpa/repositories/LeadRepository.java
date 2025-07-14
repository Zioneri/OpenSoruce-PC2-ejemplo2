package com.zillow.platform.u202417468.pc4307u202417468.q.infrastructure.persistence.jpa.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.zillow.platform.u202417468.pc4307u202417468.q.domain.model.aggregates.Lead;
import com.zillow.platform.u202417468.pc4307u202417468.q.domain.model.valueobjects.ELeadSource;

@Repository
public interface LeadRepository extends JpaRepository<Lead, Long> {
    boolean existsBySellerId_SellerIdAndEmail_EmailIgnoreCaseAndSource(
            Long sellerId,
            String email,
            ELeadSource source);
}
