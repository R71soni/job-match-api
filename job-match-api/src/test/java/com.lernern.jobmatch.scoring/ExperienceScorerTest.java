package com.lernern.jobmatch.scoring;

import com.lernern.jobmatch.entity.Candidate;
import com.lernern.jobmatch.entity.Job;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ExperienceScorerTest {

    private final ExperienceScorer experienceScorer =
            new ExperienceScorer();

    @Test
    void candidateBelowRequiredExperienceShouldBePenalized() {

        Candidate candidate = new Candidate();

        candidate.setYearsOfExperience(2);

        Job job = new Job();

        job.setMinYearsExperience(3);

        double score =
                experienceScorer.calculateScore(
                        candidate,
                        job
                );

        assertEquals(
                13.333333,
                score,
                0.001
        );
    }
}