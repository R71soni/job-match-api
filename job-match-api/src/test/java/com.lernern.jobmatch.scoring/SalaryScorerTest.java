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
    void shouldReturnFullScoreWhenSalaryMatches() {

        Candidate candidate = new Candidate();
        candidate.setExpectedSalary(300000);

        Job job = new Job();

        SalaryRange salaryRange = new SalaryRange();
        salaryRange.setMin(300000);
        salaryRange.setMax(500000);

        job.setSalaryRange(salaryRange);

        double score = salaryScorer.score(candidate, job);

        assertEquals(15.0, score);
    }
}