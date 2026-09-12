package com.lernern.jobmatch.scoring;

import com.lernern.jobmatch.entity.Candidate;
import com.lernern.jobmatch.entity.Job;
import com.lernern.jobmatch.entity.RequiredSkill;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class SkillScorerTest {

    private final SkillScorer skillScorer = new SkillScorer();

    @Test
    void shouldRejectJobWhenMustHaveSkillIsMissing() {

        // Candidate has only Java
        Candidate candidate = new Candidate();

        candidate.setSkills(
                List.of("Java")
        );

        // Job requires Java and Spring Boot
        Job job = new Job();

        RequiredSkill java = new RequiredSkill();
        java.setSkill("Java");
        java.setType("MUST_HAVE");

        RequiredSkill springBoot = new RequiredSkill();
        springBoot.setSkill("Spring Boot");
        springBoot.setType("MUST_HAVE");

        job.setRequiredSkills(
                List.of(java, springBoot)
        );

        // Check
        boolean result =
                skillScorer.hasAllMustHaveSkills(
                        candidate,
                        job
                );

        // Spring Boot is missing
        assertFalse(result);
    }

    @Test
    void shouldAcceptJobWhenAllMustHaveSkillsArePresent() {

        Candidate candidate = new Candidate();

        candidate.setSkills(
                List.of(
                        "Java",
                        "Spring Boot"
                )
        );

        Job job = new Job();

        RequiredSkill java = new RequiredSkill();
        java.setSkill("Java");
        java.setType("MUST_HAVE");

        RequiredSkill springBoot = new RequiredSkill();
        springBoot.setSkill("Spring Boot");
        springBoot.setType("MUST_HAVE");

        job.setRequiredSkills(
                List.of(java, springBoot)
        );

        boolean result =
                skillScorer.hasAllMustHaveSkills(
                        candidate,
                        job
                );

        assertTrue(result);
    }

    @Test
    void niceToHaveSkillShouldIncreaseScore() {

        Candidate candidate = new Candidate();

        candidate.setSkills(
                List.of(
                        "Java",
                        "Spring Boot",
                        "SQL"
                )
        );

        Job job = new Job();

        RequiredSkill java = new RequiredSkill();
        java.setSkill("Java");
        java.setType("MUST_HAVE");

        RequiredSkill springBoot = new RequiredSkill();
        springBoot.setSkill("Spring Boot");
        springBoot.setType("MUST_HAVE");

        RequiredSkill sql = new RequiredSkill();
        sql.setSkill("SQL");
        sql.setType("NICE_TO_HAVE");

        job.setRequiredSkills(
                List.of(java, springBoot, sql)
        );

        double score =
                skillScorer.calculateScore(
                        candidate,
                        job
                );

        assertEquals(50.0, score);
    }
}

