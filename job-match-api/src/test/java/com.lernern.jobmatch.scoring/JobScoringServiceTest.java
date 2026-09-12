package com.lernern.jobmatch.scoring;

import com.lernern.jobmatch.dto.ScoreBreakdown;
import com.lernern.jobmatch.entity.Candidate;
import com.lernern.jobmatch.entity.Job;
import com.lernern.jobmatch.entity.RequiredSkill;
import com.lernern.jobmatch.entity.SalaryRange;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class JobScoringServiceTest {

    @Test
    void shouldCalculateScoreBreakdown() {

        SkillScorer skillScorer =
                new SkillScorer();

        ExperienceScorer experienceScorer =
                new ExperienceScorer();

        LocationScorer locationScorer =
                new LocationScorer();

        SalaryScorer salaryScorer =
                new SalaryScorer();

        JobScoringService service =
                new JobScoringService(
                        skillScorer,
                        experienceScorer,
                        locationScorer,
                        salaryScorer
                );

        // Candidate
        Candidate candidate = new Candidate();

        candidate.setSkills(
                List.of(
                        "Java",
                        "Spring Boot"
                )
        );

        candidate.setYearsOfExperience(2);
        candidate.setLocation("Delhi");
        candidate.setExpectedSalary(500000);

        // Required skills
        RequiredSkill javaSkill =
                new RequiredSkill();

        javaSkill.setSkill("Java");
        javaSkill.setType("MUST_HAVE");

        RequiredSkill springBootSkill =
                new RequiredSkill();

        springBootSkill.setSkill("Spring Boot");
        springBootSkill.setType("MUST_HAVE");

        // Job
        Job job = new Job();

        job.setMinYearsExperience(1);
        job.setLocation("Delhi");
        job.setRemoteAllowed(true);

        job.setRequiredSkills(
                List.of(
                        javaSkill,
                        springBootSkill
                )
        );

        // Salary range
        SalaryRange salaryRange =
                new SalaryRange();

        salaryRange.setMin(400000);
        salaryRange.setMax(800000);

        job.setSalaryRange(salaryRange);

        // Calculate breakdown
        ScoreBreakdown breakdown =
                service.calculateBreakdown(
                        candidate,
                        job
                );

        // Verify individual scores
        assertEquals(
                40.0,
                breakdown.getSkills()
        );

        assertEquals(
                20.0,
                breakdown.getExperience()
        );

        assertEquals(
                15.0,
                breakdown.getLocation()
        );

        assertEquals(
                15.0,
                breakdown.getSalary()
        );

        // Verify overall score
        double overallScore =
                service.calculateOverallScore(
                        breakdown
                );

        assertEquals(
                90.0,
                overallScore
        );
    }
}