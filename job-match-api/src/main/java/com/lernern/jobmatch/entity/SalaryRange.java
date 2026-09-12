package com.lernern.jobmatch.entity;

<<<<<<< HEAD
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
=======
import jakarta.persistence.Embeddable;

@Embeddable
public class SalaryRange {

    private double min;
>>>>>>> d5e521b (Add job creation API)
    private double max;

    public SalaryRange() {
    }

<<<<<<< HEAD
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

=======
>>>>>>> d5e521b (Add job creation API)
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