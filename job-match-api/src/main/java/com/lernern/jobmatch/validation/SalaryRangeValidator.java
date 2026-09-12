package com.lernern.jobmatch.validation;

import com.lernern.jobmatch.entity.SalaryRange;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class SalaryRangeValidator
        implements ConstraintValidator<ValidSalaryRange, SalaryRange> {

    @Override
    public boolean isValid(
            SalaryRange salaryRange,
            ConstraintValidatorContext context) {

        if (salaryRange == null) {
            return true;
        }

        return salaryRange.getMin() <= salaryRange.getMax();
    }
}