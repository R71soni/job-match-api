package com.lernern.jobmatch.entity;

import jakarta.persistence.Embeddable;
import jakarta.validation.constraints.Min;

@Embeddable
public class SalaryRange {

    @Min(value = 0, message = "Minimum salary cannot be negative")
    private double min;

    @Min(value = 0, message = "Maximum salary cannot be negative")
    private double max;

    public SalaryRange() {
    }

    public double getMin() {
        return min;
    }

    public void setMin(double min) {
        this.min = min;
    }

    public double getMax() {
        return max;
    }

    public void setMax(double max) {
        this.max = max;
    }
}