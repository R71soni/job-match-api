package com.lernern.jobmatch.scoring;

import com.lernern.jobmatch.entity.Candidate;
import com.lernern.jobmatch.entity.Job;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LocationScorerTest {

    private final LocationScorer locationScorer =
            new LocationScorer();

    @Test
    void exactLocationShouldGetFullScore() {

        Candidate candidate = new Candidate();
        candidate.setLocation("Delhi");

        Job job = new Job();
        job.setLocation("Delhi");
        job.setRemoteAllowed(false);

        double score =
                locationScorer.calculateScore(
                        candidate,
                        job
                );

        assertEquals(15.0, score);
    }

    @Test
    void remoteJobShouldGetRemoteScore() {

        Candidate candidate = new Candidate();
        candidate.setLocation("Delhi");

        Job job = new Job();
        job.setLocation("Bangalore");
        job.setRemoteAllowed(true);

        double score =
                locationScorer.calculateScore(
                        candidate,
                        job
                );

        assertEquals(10.0, score);
    }
}