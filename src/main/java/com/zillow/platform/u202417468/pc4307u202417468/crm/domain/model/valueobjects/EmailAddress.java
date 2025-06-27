package com.zillow.platform.u202417468.pc4307u202417468.crm.domain.model.valueobjects;

import jakarta.persistence.Embeddable;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Embeddable
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class EmailAddress {
    @Email
    @NotBlank
    private String email;

    public EmailAddress(String email) {
        this.email = email;
    }
}
