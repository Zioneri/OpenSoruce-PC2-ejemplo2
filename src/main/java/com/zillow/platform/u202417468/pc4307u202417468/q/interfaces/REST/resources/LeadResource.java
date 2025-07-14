package com.zillow.platform.u202417468.pc4307u202417468.q.interfaces.REST.resources;

public record LeadResource(
                Long id,
                Long sellerId,
                String email,
                String fullName,
                String phone,
                Integer age,
                Double incomeLevel,
                String locationPreference,
                Integer minBedrooms,
                Double budgetAmount,
                String budgetCurrency,
                String source,
                String status,
                String createdAt,
                String updatedAt) {

}
