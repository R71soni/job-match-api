package com.lernern.jobmatch.service;

import com.lernern.jobmatch.dto.RecommendationResponse;
import com.lernern.jobmatch.dto.ScoreBreakdown;
import com.lernern.jobmatch.entity.Candidate;
import com.lernern.jobmatch.entity.Job;
import com.lernern.jobmatch.exception.CandidateNotFoundException;
import com.lernern.jobmatch.repository.CandidateRepository;
import com.lernern.jobmatch.repository.JobRepository;
import com.lernern.jobmatch.scoring.JobScoringService;
import com.lernern.jobmatch.scoring.SkillScorer;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.List;

@Service
public class RecommendationService {

    private final CandidateRepository candidateRepository;
    private final JobRepository jobRepository;
    private final SkillScorer skillScorer;
    private final JobScoringService jobScoringService;

    public RecommendationService(
            CandidateRepository candidateRepository,
            JobRepository jobRepository,
            SkillScorer skillScorer,
            JobScoringService jobScoringService) {

        this.candidateRepository = candidateRepository;
        this.jobRepository = jobRepository;
        this.skillScorer = skillScorer;
        this.jobScoringService = jobScoringService;
    }

    public List<RecommendationResponse> getRecommendations(
            Long candidateId,
            int limit) {

        Candidate candidate = candidateRepository
                .findById(candidateId)
                .orElseThrow(() ->
                        new CandidateNotFoundException(
                                "Candidate not found with id: " + candidateId
                        )
                );

        List<Job> jobs = jobRepository.findAll();

        return jobs.stream()
                .filter(job ->
                        skillScorer.hasAllMustHaveSkills(
                                candidate,
                                job
                        )
                )
                .map(job -> {

                    ScoreBreakdown breakdown =
                            jobScoringService.calculateBreakdown(
                                    candidate,
                                    job
                            );

                    double overallScore =
                            jobScoringService.calculateOverallScore(
                                    breakdown
                            );

                    return new RecommendationResponse(
                            job,
                            overallScore,
                            breakdown
                    );
                })
                .sorted(
                        Comparator.comparingDouble(
                                RecommendationResponse::getOverallScore
                        ).reversed()
                )
                .limit(limit)
                .toList();
    }
}