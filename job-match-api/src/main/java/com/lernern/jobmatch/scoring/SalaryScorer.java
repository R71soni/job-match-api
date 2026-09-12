package com.lernern.jobmatch.scoring;

import com.lernern.jobmatch.entity.Candidate;
import com.lernern.jobmatch.entity.Job;
import com.lernern.jobmatch.entity.SalaryRange;
import org.springframework.stereotype.Component;

@Component
public class SalaryScorer {

    private static final double MAX_SCORE = 15.0;

    public double calculateScore(
            Candidate candidate,
            Job job) {

        double expectedSalary =
                candidate.getExpectedSalary();

        SalaryRange range =
                job.getSalaryRange();

        if (range == null) {
            return 0.0;
        }

        double min = range.getMin();
        double max = range.getMax();

        // Invalid salary range
        if (min > max) {
            return 0.0;
        }

        // Job comfortably meets expectation
        if (min >= expectedSalary) {
            return MAX_SCORE;
        }

        // Candidate expectation is inside job range
        if (expectedSalary >= min
                && expectedSalary <= max) {

            return MAX_SCORE;
        }

        // Job maximum is below expectation
        if (max < expectedSalary) {

            double gap =
                    expectedSalary - max;

            double rangeSize =
                    Math.max(expectedSalary - min, 1);

            double penalty =
                    gap / rangeSize;

            double score =
                    MAX_SCORE * (1 - penalty);

            return Math.max(score, 0.0);
        }

        return 0.0;
    }
}