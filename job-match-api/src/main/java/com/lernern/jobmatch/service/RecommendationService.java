package com.lernern.jobmatch.service;

import com.lernern.jobmatch.dto.RecommendationResponse;
import com.lernern.jobmatch.dto.ScoreBreakdown;
import com.lernern.jobmatch.entity.Candidate;
import com.lernern.jobmatch.entity.Job;
<<<<<<< HEAD
import com.lernern.jobmatch.exception.CandidateNotFoundException;
=======
>>>>>>> 5cfc5c5 (Implement job recommendation engine)
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

        // 1. Find candidate
        Candidate candidate = candidateRepository
                .findById(candidateId)
                .orElseThrow(() ->
<<<<<<< HEAD
                        new CandidateNotFoundException(
                                "Candidate not found with id: " + candidateId
                        ));
=======
                        new RuntimeException("Candidate not found"));
>>>>>>> 5cfc5c5 (Implement job recommendation engine)

        // 2. Get all jobs
        List<Job> jobs = jobRepository.findAll();

        // 3. Score eligible jobs
        return jobs.stream()

                // 4. Hard filter: must-have skills
                .filter(job ->
                        skillScorer.hasAllMustHaveSkills(
                                candidate,
<<<<<<< HEAD
                                job
                        ))

                // 5. Calculate score and create response
=======
                                job))

                // 5. Convert Job -> RecommendationResponse
>>>>>>> 5cfc5c5 (Implement job recommendation engine)
                .map(job -> {

                    ScoreBreakdown breakdown =
                            jobScoringService.calculateBreakdown(
                                    candidate,
<<<<<<< HEAD
                                    job
                            );

                    double overallScore =
                            jobScoringService.calculateOverallScore(
                                    breakdown
                            );
=======
                                    job);

                    double overallScore =
                            jobScoringService.calculateOverallScore(
                                    breakdown);
>>>>>>> 5cfc5c5 (Implement job recommendation engine)

                    return new RecommendationResponse(
                            job,
                            overallScore,
                            breakdown
                    );
                })

                // 6. Highest score first
                .sorted(
                        Comparator.comparingDouble(
                                RecommendationResponse::getOverallScore
                        ).reversed()
                )

<<<<<<< HEAD
                // 7. Top N recommendations
=======
                // 7. Top N
>>>>>>> 5cfc5c5 (Implement job recommendation engine)
                .limit(limit)

                .toList();
    }
}