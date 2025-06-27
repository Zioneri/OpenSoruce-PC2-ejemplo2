package com.zillow.platform.u202417468.pc4307u202417468.crm.domain.model.valueobjects;

import jakarta.persistence.Embeddable;
import jakarta.validation.constraints.NotNull;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Embeddable
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class SellerId {
    @NotNull
    private Long sellerId;

    public SellerId(Long sellerId) {
        if (sellerId == null || sellerId <= 0)
            throw new IllegalArgumentException("sellerId must be positive");
        this.sellerId = sellerId;
    }
}
