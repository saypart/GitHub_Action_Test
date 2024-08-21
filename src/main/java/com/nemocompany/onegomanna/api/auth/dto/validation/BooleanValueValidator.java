package com.nemocompany.onegomanna.api.auth.dto.validation;


import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class BooleanValueValidator implements ConstraintValidator<ValidBoolean, String> {

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        if (value == null) {
            return true;
        }
        return value.equalsIgnoreCase("true") || value.equalsIgnoreCase("false");
    }
}
