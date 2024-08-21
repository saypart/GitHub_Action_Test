package com.nemocompany.onegomanna.api.auth.dto.validation;


import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class DateInRangeValidator implements ConstraintValidator<DateInRange, LocalDate> {

    private LocalDate startDate;
    private LocalDate endDate;

    @Override
    public void initialize(DateInRange constraintAnnotation) {
        this.startDate = LocalDate.parse(constraintAnnotation.startDate(), DateTimeFormatter.ISO_LOCAL_DATE);
        this.endDate = LocalDate.now();
    }

    @Override
    public boolean isValid(LocalDate date, ConstraintValidatorContext context) {
        if (date == null) {
            return true;
        }
        return (date.isEqual(startDate) || date.isEqual(endDate) || (date.isAfter(startDate) && date.isBefore(endDate)));
    }
}
