package com.zillow.platform.u202417468.pc4307u202417468.crm.domain.model.commands;

public record CreateLeadCommand(
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
        String source) {

}
