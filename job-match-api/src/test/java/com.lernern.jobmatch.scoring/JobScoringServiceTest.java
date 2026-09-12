package com.lernern.jobmatch.scoring;

import com.lernern.jobmatch.dto.ScoreBreakdown;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class JobScoringServiceTest {

    @Test
    void overallScoreShouldBeSumOfAllComponents() {

        JobScoringService service =
                new JobScoringService(
                        null,
                        null,
                        null,
                        null
                );

        ScoreBreakdown breakdown =
                new ScoreBreakdown(
                        40.0,
                        20.0,
                        15.0,
                        15.0
                );

        double result =
                service.calculateOverallScore(breakdown);

        assertEquals(90.0, result, 0.001);
    }
}