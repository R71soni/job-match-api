package com.lernern.jobmatch.entity;

import com.lernern.jobmatch.validation.ValidSalaryRange;
import jakarta.persistence.*;
import jakarta.validation.constraints.Min;

@ValidSalaryRange
@Entity
public class SalaryRange {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Min(value = 0, message = "salary min cannot be negative")
    private double min;

    @Min(value = 0, message = "salary max cannot be negative")
    private double max;

    public SalaryRange() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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