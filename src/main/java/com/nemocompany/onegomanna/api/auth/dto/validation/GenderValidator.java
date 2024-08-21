package com.nemocompany.onegomanna.api.auth.dto.validation;


import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class GenderValidator implements ConstraintValidator<ValidGender, String> {

    @Override
    public boolean isValid(String gender, ConstraintValidatorContext context) {
        if (gender == null) {
            return true;
        }
        return gender.equals("MALE") || gender.equals("FEMALE");
    }
}
