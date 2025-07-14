package com.zillow.platform.u202417468.pc4307u202417468.q.domain.model.valueobjects;

import jakarta.persistence.Embeddable;
import jakarta.validation.constraints.NotNull;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Embeddable
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class PersonalInfo {
    @NotNull
    private Integer age;

    @NotNull
    private Double incomeLevel;

    public PersonalInfo(Integer age, Double incomeLevel) {
        if (age == null || age < 18 || age > 100)
            throw new IllegalArgumentException("Age must be between 18 and 100");
        if (incomeLevel == null || incomeLevel <= 0)
            throw new IllegalArgumentException("Income level must be > 0");
        this.age = age;
        this.incomeLevel = incomeLevel;
    }
}
