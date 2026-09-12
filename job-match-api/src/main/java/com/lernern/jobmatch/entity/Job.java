package com.lernern.jobmatch.entity;

import jakarta.persistence.*;
<<<<<<< HEAD
import jakarta.validation.Valid;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;

import java.util.List;

@Entity
=======
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "jobs")
>>>>>>> d5e521b (Add job creation API)
public class Job {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

<<<<<<< HEAD
    @NotBlank(message = "title is required")
    private String title;

    @Min(value = 0, message = "minYearsExperience cannot be negative")
    private int minYearsExperience;

    @NotBlank(message = "location is required")
=======
    private String title;

    @ElementCollection
    private List<RequiredSkill> requiredSkills = new ArrayList<>();

    private int minYearsExperience;

>>>>>>> d5e521b (Add job creation API)
    private String location;

    private boolean remoteAllowed;

<<<<<<< HEAD
    @NotNull(message = "salaryRange is required")
    @Valid
    @OneToOne(cascade = CascadeType.ALL)
    private SalaryRange salaryRange;

    @NotEmpty(message = "requiredSkills must contain at least one skill")
    @OneToMany(cascade = CascadeType.ALL)
    private List<@Valid RequiredSkill> requiredSkills;

=======
    @Embedded
    private SalaryRange salaryRange;

>>>>>>> d5e521b (Add job creation API)
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

<<<<<<< HEAD
=======
    public List<RequiredSkill> getRequiredSkills() {
        return requiredSkills;
    }

    public void setRequiredSkills(List<RequiredSkill> requiredSkills) {
        this.requiredSkills = requiredSkills;
    }

>>>>>>> d5e521b (Add job creation API)
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
<<<<<<< HEAD

    public List<RequiredSkill> getRequiredSkills() {
        return requiredSkills;
    }

    public void setRequiredSkills(List<RequiredSkill> requiredSkills) {
        this.requiredSkills = requiredSkills;
    }
=======
>>>>>>> d5e521b (Add job creation API)
}