package com.lernern.jobmatch.scoring;

import com.lernern.jobmatch.entity.Candidate;
import com.lernern.jobmatch.entity.Job;
import com.lernern.jobmatch.entity.SalaryRange;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SalaryScorerTest {

    private final SalaryScorer salaryScorer =
            new SalaryScorer();

    @Test
    void shouldGiveFullScoreWhenExpectedSalaryIsWithinRange() {

        Candidate candidate = new Candidate();
        candidate.setExpectedSalary(500000);

        SalaryRange salaryRange = new SalaryRange();
        salaryRange.setMin(400000);
        salaryRange.setMax(800000);

        Job job = new Job();
        job.setSalaryRange(salaryRange);

        double score =
                salaryScorer.calculateScore(candidate, job);

        assertEquals(15.0, score);
    }

    @Test
    void shouldGiveFullScoreWhenExpectedSalaryIsBelowJobMaximum() {

        Candidate candidate = new Candidate();
        candidate.setExpectedSalary(300000);

        SalaryRange salaryRange = new SalaryRange();
        salaryRange.setMin(400000);
        salaryRange.setMax(800000);

        Job job = new Job();
        job.setSalaryRange(salaryRange);

        double score =
                salaryScorer.calculateScore(candidate, job);

        assertEquals(15.0, score);
    }

    @Test
    void shouldGiveZeroWhenExpectedSalaryIsFarAboveJobMaximum() {

        Candidate candidate = new Candidate();
        candidate.setExpectedSalary(1000000);

        SalaryRange salaryRange = new SalaryRange();
        salaryRange.setMin(300000);
        salaryRange.setMax(500000);

        Job job = new Job();
        job.setSalaryRange(salaryRange);

        double score =
                salaryScorer.calculateScore(candidate, job);

        assertEquals(0.0, score);
    }

    @Test
    void shouldGiveZeroWhenSalaryRangeIsMissing() {

        Candidate candidate = new Candidate();
        candidate.setExpectedSalary(500000);

        Job job = new Job();
        job.setSalaryRange(null);

        double score =
                salaryScorer.calculateScore(candidate, job);

        assertEquals(0.0, score);
    }
}