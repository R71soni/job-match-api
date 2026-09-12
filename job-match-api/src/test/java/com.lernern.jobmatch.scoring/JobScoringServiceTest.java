package com.lernern.jobmatch.scoring;

import com.lernern.jobmatch.dto.ScoreBreakdown;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class JobScoringServiceTest {

    @Test
    void shouldCreateScoreBreakdown() {

        ScoreBreakdown breakdown = new ScoreBreakdown(
                40.0,  // skills
                20.0,  // experience
                15.0,  // location
                25.0   // salary
        );

        assertEquals(40.0, breakdown.getSkillScore());
        assertEquals(20.0, breakdown.getExperienceScore());
        assertEquals(15.0, breakdown.getLocationScore());
        assertEquals(25.0, breakdown.getSalaryScore());
    }
}