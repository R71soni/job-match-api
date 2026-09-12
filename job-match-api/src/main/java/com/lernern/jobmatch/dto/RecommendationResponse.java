package com.lernern.jobmatch.dto;

import com.lernern.jobmatch.entity.Job;

public class RecommendationResponse {

    private Job job;
    private double overallScore;
    private ScoreBreakdown breakdown;

    public RecommendationResponse(
            Job job,
            double overallScore,
            ScoreBreakdown breakdown) {

        this.job = job;
        this.overallScore = overallScore;
        this.breakdown = breakdown;
    }

    public Job getJob() {
        return job;
    }

    public double getOverallScore() {
        return overallScore;
    }

    public ScoreBreakdown getBreakdown() {
        return breakdown;
    }
}