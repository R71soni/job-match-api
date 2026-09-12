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

        SalaryRange range = job.getSalaryRange();

        // No salary range means no salary match score
        if (range == null) {
            return 0.0;
        }

        double expectedSalary =
                candidate.getExpectedSalary();

        double min =
                range.getMin();

        double max =
                range.getMax();

        // Expected salary is within or below
        // the job's range.
        if (expectedSalary <= max) {
            return MAX_SCORE;
        }

        // Expected salary is higher than
        // the job's maximum salary.
        double gap =
                expectedSalary - max;

        double salaryRangeSize =
                Math.max(max - min, 1.0);

        double penalty =
                gap / salaryRangeSize;

        double score =
                MAX_SCORE * (1.0 - penalty);

        return Math.max(score, 0.0);
    }
}