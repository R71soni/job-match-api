package com.lernern.jobmatch.dto;

import com.lernern.jobmatch.entity.Job;

public class RecommendationResponse {

    private JobResponse job;
    private double overallScore;
    private ScoreBreakdown breakdown;

    public RecommendationResponse(
            Job job,
            double overallScore,
            ScoreBreakdown breakdown) {

        this.job = new JobResponse(job);
        this.overallScore = overallScore;
        this.breakdown = breakdown;
    }

    public JobResponse getJob() {
        return job;
    }

    public double getOverallScore() {
        return overallScore;
    }

    public ScoreBreakdown getBreakdown() {
        return breakdown;
    }
}