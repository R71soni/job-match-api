package com.lernern.jobmatch.validation;

import com.lernern.jobmatch.entity.SalaryRange;
import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.*;

@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = SalaryRangeValidator.class)
@Documented
public @interface ValidSalaryRange {

    String message() default "salary min cannot be greater than salary max";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}