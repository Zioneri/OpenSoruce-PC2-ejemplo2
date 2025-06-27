package com.zillow.platform.u202417468.pc4307u202417468.crm.interfaces.REST.resources;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

public record CreateLeadResource(
                @NotBlank @Email String email,
                @NotBlank String fullName,
                String phone,
                @NotNull @Min(18) @Max(100) Integer age,
                @NotNull @Positive Double incomeLevel,
                String locationPreference,
                @Positive Integer minBedrooms,
                @NotNull @Positive Double budgetAmount,
                @NotBlank String budgetCurrency,
                @NotBlank String source) {

}
