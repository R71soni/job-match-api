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

        if (candidate.getLocation() != null
                && job.getLocation() != null
                && candidate.getLocation()
                .equalsIgnoreCase(job.getLocation())) {

            return MAX_SCORE;
        }

        if (job.isRemoteAllowed()) {
            return REMOTE_SCORE;
        }

        return 0.0;
    }
}