package com.lernern.jobmatch.scoring;

import com.lernern.jobmatch.entity.Candidate;
import com.lernern.jobmatch.entity.Job;
import org.springframework.stereotype.Component;

@Component
public class ExperienceScorer {

    private static final double MAX_SCORE = 20.0;

    public double calculateScore(
            Candidate candidate,
            Job job) {

        int candidateExperience =
                candidate.getYearsOfExperience();

        int requiredExperience =
                job.getMinYearsExperience();

        if (requiredExperience <= 0) {
            return MAX_SCORE;
        }

        if (candidateExperience >= requiredExperience) {
            return MAX_SCORE;
        }

        return ((double) candidateExperience
                / requiredExperience)
                * MAX_SCORE;
    }
}