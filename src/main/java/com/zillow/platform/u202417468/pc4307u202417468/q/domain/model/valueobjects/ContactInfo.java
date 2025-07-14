package com.zillow.platform.u202417468.pc4307u202417468.q.domain.model.valueobjects;

import jakarta.persistence.Embeddable;
import jakarta.validation.constraints.NotBlank;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Embeddable
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class ContactInfo {
    @NotBlank
    private String fullName;

    private String phone;

    public ContactInfo(String fullName, String phone) {
        if (fullName == null || fullName.isBlank())
            throw new IllegalArgumentException("Full name is mandatory");
        this.fullName = fullName;
        this.phone = (phone != null && phone.isBlank()) ? null : phone;
    }
}
