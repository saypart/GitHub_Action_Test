package com.nemocompany.onegomanna.api.auth.dto.validation;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Constraint(validatedBy = DateInRangeValidator.class)
@Target({ ElementType.FIELD, ElementType.METHOD, ElementType.ANNOTATION_TYPE, ElementType.PARAMETER })
@Retention(RetentionPolicy.RUNTIME)
public @interface DateInRange {
    String message() default "Date must be within the specified range";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
    String startDate();
}

