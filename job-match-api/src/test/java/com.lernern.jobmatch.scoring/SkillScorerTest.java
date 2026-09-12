package com.lernern.jobmatch.scoring;

import com.lernern.jobmatch.entity.Candidate;
import com.lernern.jobmatch.entity.Job;
import com.lernern.jobmatch.entity.RequiredSkill;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;

class SkillScorerTest {

    private final SkillScorer skillScorer = new SkillScorer();

    @Test
    void shouldRejectJobWhenMustHaveSkillIsMissing() {

        Candidate candidate = new Candidate();
        candidate.setSkills(List.of("Java"));

        RequiredSkill java = new RequiredSkill();
        java.setSkill("Java");
        java.setType("MUST_HAVE");

        RequiredSkill springBoot = new RequiredSkill();
        springBoot.setSkill("Spring Boot");
        springBoot.setType("MUST_HAVE");

        Job job = new Job();
        job.setRequiredSkills(List.of(java, springBoot));

        boolean result =
                skillScorer.hasAllMustHaveSkills(candidate, job);

        assertFalse(result);
    }

    @Test
    void shouldAcceptJobWhenAllMustHaveSkillsArePresent() {

        Candidate candidate = new Candidate();
        candidate.setSkills(List.of("Java", "Spring Boot"));

        RequiredSkill java = new RequiredSkill();
        java.setSkill("Java");
        java.setType("MUST_HAVE");

        RequiredSkill springBoot = new RequiredSkill();
        springBoot.setSkill("Spring Boot");
        springBoot.setType("MUST_HAVE");

        Job job = new Job();
        job.setRequiredSkills(List.of(java, springBoot));

        boolean result =
                skillScorer.hasAllMustHaveSkills(candidate, job);

        assertTrue(result);
    }

    @Test
    void shouldCalculateFullScoreWhenAllSkillsMatch() {

        Candidate candidate = new Candidate();
        candidate.setSkills(List.of("Java", "Spring Boot"));

        RequiredSkill java = new RequiredSkill();
        java.setSkill("Java");
        java.setType("MUST_HAVE");

        RequiredSkill springBoot = new RequiredSkill();
        springBoot.setSkill("Spring Boot");
        springBoot.setType("MUST_HAVE");

        Job job = new Job();
        job.setRequiredSkills(List.of(java, springBoot));

        double score =
                skillScorer.calculateScore(candidate, job);

        assertEquals(40.0, score);
    }
}