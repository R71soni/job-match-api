package com.lernern.jobmatch.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "jobs")
public class Job {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "Title is required")
    private String title;

    @NotNull(message = "Required skills are required")
    @NotEmpty(message = "At least one required skill is needed")
    @ElementCollection
    private List<RequiredSkill> requiredSkills = new ArrayList<>();

    @Min(value = 0, message = "Minimum years of experience cannot be negative")
    private int minYearsExperience;

    @NotBlank(message = "Location is required")
    private String location;

    private boolean remoteAllowed;

    @Embedded
    @NotNull(message = "Salary range is required")
    private SalaryRange salaryRange;

    public Job() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public List<RequiredSkill> getRequiredSkills() {
        return requiredSkills;
    }

    public void setRequiredSkills(List<RequiredSkill> requiredSkills) {
        this.requiredSkills = requiredSkills;
    }

    public int getMinYearsExperience() {
        return minYearsExperience;
    }

    public void setMinYearsExperience(int minYearsExperience) {
        this.minYearsExperience = minYearsExperience;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public boolean isRemoteAllowed() {
        return remoteAllowed;
    }

    public void setRemoteAllowed(boolean remoteAllowed) {
        this.remoteAllowed = remoteAllowed;
    }

    public SalaryRange getSalaryRange() {
        return salaryRange;
    }

    public void setSalaryRange(SalaryRange salaryRange) {
        this.salaryRange = salaryRange;
    }
}