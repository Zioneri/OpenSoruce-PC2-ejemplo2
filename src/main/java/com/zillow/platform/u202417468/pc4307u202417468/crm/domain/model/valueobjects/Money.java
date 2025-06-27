package com.zillow.platform.u202417468.pc4307u202417468.crm.domain.model.valueobjects;

import jakarta.persistence.Embeddable;
import jakarta.validation.constraints.NotNull;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Embeddable
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Money {
    @NotNull
    private Double amount;

    private String currency;

    public Money(Double amount, String currency) {
        if (amount == null || amount < 5_000)
            throw new IllegalArgumentException("Amount must be ≥ 5,000");
        if (!"USD".equalsIgnoreCase(currency))
            throw new IllegalArgumentException("Currency must be USD");
        this.amount = amount;
        this.currency = "USD";
    }
}
