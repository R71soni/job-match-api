package com.lernern.jobmatch.dto;

public class ScoreBreakdown {

    private double skills;
    private double experience;
    private double location;
    private double salary;

    public ScoreBreakdown(
            double skills,
            double experience,
            double location,
            double salary) {

        this.skills = skills;
        this.experience = experience;
        this.location = location;
        this.salary = salary;
    }

    public double getSkills() {
        return skills;
    }

    public double getExperience() {
        return experience;
    }

    public double getLocation() {
        return location;
    }

    public double getSalary() {
        return salary;
    }

    public double getSkillScore() {
        return skills;
    }

    public double getExperienceScore() {
        return experience;
    }

    public double getLocationScore() {
        return location;
    }

    public double getSalaryScore() {
        return salary;
    }
}