package com.zillow.platform.u202417468.pc4307u202417468.crm.domain.model.aggregates;

import com.zillow.platform.u202417468.pc4307u202417468.crm.domain.model.commands.CreateLeadCommand;
import com.zillow.platform.u202417468.pc4307u202417468.crm.domain.model.valueobjects.ContactInfo;
import com.zillow.platform.u202417468.pc4307u202417468.crm.domain.model.valueobjects.ELeadSource;
import com.zillow.platform.u202417468.pc4307u202417468.crm.domain.model.valueobjects.ELeadStatus;
import com.zillow.platform.u202417468.pc4307u202417468.crm.domain.model.valueobjects.EmailAddress;
import com.zillow.platform.u202417468.pc4307u202417468.crm.domain.model.valueobjects.Money;
import com.zillow.platform.u202417468.pc4307u202417468.crm.domain.model.valueobjects.PersonalInfo;
import com.zillow.platform.u202417468.pc4307u202417468.crm.domain.model.valueobjects.PurchaseIntent;
import com.zillow.platform.u202417468.pc4307u202417468.crm.domain.model.valueobjects.SellerId;
import com.zillow.platform.u202417468.pc4307u202417468.shared.domain.model.aggregates.AuditableAbstractAggregateRoot;

import jakarta.persistence.Column;
import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

/**
 * Lead aggregate root for Zillow CRM.
 *
 * Business rules:
 * • sellerId, email, contactInfo, personalInfo, purchaseIntent, budget, source
 * are mandatory.
 * • status initializes automatically as NEW.
 * • No two leads with the same email & source (rule enforced in application
 * layer).
 *
 * @author Fabrizzio Pereira
 */
@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Lead extends AuditableAbstractAggregateRoot<Lead> {
    @Embedded
    private SellerId sellerId;

    @Embedded
    private EmailAddress email;

    @Embedded
    private ContactInfo contactInfo;

    @Embedded
    private PersonalInfo personalInfo;

    @Embedded
    private PurchaseIntent purchaseIntent;

    @Embedded
    private Money budget;

    @Enumerated(EnumType.STRING)
    @Column(name = "lead_source", nullable = false, length = 20)
    private ELeadSource source;

    @Enumerated(EnumType.STRING)
    @Column(name = "lead_status", nullable = false, length = 20)
    private ELeadStatus status = ELeadStatus.NEW;

    public Lead(CreateLeadCommand command) {
        this.sellerId = new SellerId(command.sellerId());
        this.email = new EmailAddress(command.email());
        this.contactInfo = new ContactInfo(command.fullName(), command.phone());
        this.personalInfo = new PersonalInfo(command.age(), command.incomeLevel());
        this.purchaseIntent = new PurchaseIntent(command.locationPreference(), command.minBedrooms());
        this.budget = new Money(command.budgetAmount(), command.budgetCurrency());
        this.source = ELeadSource.fromName(command.source());
        this.status = ELeadStatus.NEW;
    }
}
