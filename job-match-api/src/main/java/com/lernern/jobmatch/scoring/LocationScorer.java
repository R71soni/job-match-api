package com.lernern.jobmatch.scoring;

import com.lernern.jobmatch.entity.Candidate;
import com.lernern.jobmatch.entity.Job;
import org.springframework.stereotype.Component;

@Component
public class LocationScorer {

    private static final double MAX_SCORE = 15.0;
    private static final double REMOTE_SCORE = 10.0;

    public double calculateScore(
            Candidate candidate,
            Job job) {

        String candidateLocation =
                normalize(candidate.getLocation());

        String jobLocation =
                normalize(job.getLocation());

        // Same location
        if (!candidateLocation.isEmpty()
                && !jobLocation.isEmpty()
                && candidateLocation.equals(jobLocation)) {

            return MAX_SCORE;
        }

        // Different location but remote is allowed
        if (job.isRemoteAllowed()) {
            return REMOTE_SCORE;
        }

        // Different location and remote is not allowed
        return 0.0;
    }

    private String normalize(String location) {

        if (location == null) {
            return "";
        }

        return location.trim().toLowerCase();
    }

    public double score(Candidate candidate, Job job) {
        return calculateScore(candidate, job);
    }
}