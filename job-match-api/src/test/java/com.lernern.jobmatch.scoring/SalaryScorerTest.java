package com.lernern.jobmatch.scoring;

import com.lernern.jobmatch.entity.Candidate;
import com.lernern.jobmatch.entity.Job;
import com.lernern.jobmatch.entity.SalaryRange;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SalaryScorerTest {

    private final SalaryScorer salaryScorer =
            new SalaryScorer();

    @Test
    void salaryBelowExpectedShouldGetLowScore() {

        Candidate candidate = new Candidate();

        candidate.setExpectedSalary(600000);

        Job job = new Job();

        SalaryRange salaryRange = new SalaryRange();

        salaryRange.setMin(300000);
        salaryRange.setMax(400000);

        job.setSalaryRange(salaryRange);

        double score =
                salaryScorer.calculateScore(
                        candidate,
                        job
                );

        assertEquals(5.0, score, 0.001);
    }
}