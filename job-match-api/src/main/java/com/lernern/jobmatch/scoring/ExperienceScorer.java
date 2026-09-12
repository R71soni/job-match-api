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
                Math.max(candidate.getYearsOfExperience(), 0);

        int requiredExperience =
                Math.max(job.getMinYearsExperience(), 0);

        // No experience required
        if (requiredExperience <= 0) {
            return MAX_SCORE;
        }

        // Candidate meets or exceeds requirement
        if (candidateExperience >= requiredExperience) {
            return MAX_SCORE;
        }

        // Candidate has less experience
        double score =
                ((double) candidateExperience / requiredExperience)
                        * MAX_SCORE;

        return Math.max(score, 0.0);
    }

    public double score(Candidate candidate, Job job) {
        return calculateScore(candidate, job);
    }
}