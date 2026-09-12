package com.lernern.jobmatch.scoring;

import com.lernern.jobmatch.entity.Candidate;
import com.lernern.jobmatch.entity.Job;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ExperienceScorerTest {

    private final ExperienceScorer experienceScorer =
            new ExperienceScorer();

    @Test
    void shouldGiveFullScoreWhenCandidateMeetsRequirement() {

        Candidate candidate = new Candidate();
        candidate.setYearsOfExperience(5);

        Job job = new Job();
        job.setMinYearsExperience(3);

        double score =
                experienceScorer.calculateScore(candidate, job);

        assertEquals(20.0, score);
    }

    @Test
    void shouldPenalizeCandidateBelowRequirement() {

        Candidate candidate = new Candidate();
        candidate.setYearsOfExperience(2);

        Job job = new Job();
        job.setMinYearsExperience(5);

        double score =
                experienceScorer.calculateScore(candidate, job);

        assertEquals(8.0, score);
    }

    @Test
    void shouldGiveFullScoreWhenNoExperienceRequired() {

        Candidate candidate = new Candidate();
        candidate.setYearsOfExperience(0);

        Job job = new Job();
        job.setMinYearsExperience(0);

        double score =
                experienceScorer.calculateScore(candidate, job);

        assertEquals(20.0, score);
    }
}