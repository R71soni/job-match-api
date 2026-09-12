package com.lernern.jobmatch.scoring;

import com.lernern.jobmatch.dto.ScoreBreakdown;
import com.lernern.jobmatch.entity.Candidate;
import com.lernern.jobmatch.entity.Job;
import org.springframework.stereotype.Service;

@Service
public class JobScoringService {

    private final SkillScorer skillScorer;
    private final ExperienceScorer experienceScorer;
    private final LocationScorer locationScorer;
    private final SalaryScorer salaryScorer;

    public JobScoringService(
            SkillScorer skillScorer,
            ExperienceScorer experienceScorer,
            LocationScorer locationScorer,
            SalaryScorer salaryScorer) {

        this.skillScorer = skillScorer;
        this.experienceScorer = experienceScorer;
        this.locationScorer = locationScorer;
        this.salaryScorer = salaryScorer;
    }

    public ScoreBreakdown calculateBreakdown(
            Candidate candidate,
            Job job) {

        double skills =
                skillScorer.calculateScore(candidate, job);

        double experience =
                experienceScorer.calculateScore(candidate, job);

        double location =
                locationScorer.calculateScore(candidate, job);

        double salary =
                salaryScorer.calculateScore(candidate, job);

        return new ScoreBreakdown(
                skills,
                experience,
                location,
                salary
        );
    }

    public double calculateOverallScore(
            ScoreBreakdown breakdown) {

        return breakdown.getSkills()
                + breakdown.getExperience()
                + breakdown.getLocation()
                + breakdown.getSalary();
    }
}