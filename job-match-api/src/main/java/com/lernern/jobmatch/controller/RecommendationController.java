package com.lernern.jobmatch.controller;

import com.lernern.jobmatch.dto.RecommendationResponse;
import com.lernern.jobmatch.service.RecommendationService;
<<<<<<< HEAD
import jakarta.validation.constraints.Min;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
=======
>>>>>>> 5cfc5c5 (Implement job recommendation engine)
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
<<<<<<< HEAD
@RequestMapping("/recommendations")
@Validated
=======
@RequestMapping("/candidates")
>>>>>>> 5cfc5c5 (Implement job recommendation engine)
public class RecommendationController {

    private final RecommendationService recommendationService;

    public RecommendationController(
            RecommendationService recommendationService) {

        this.recommendationService = recommendationService;
    }

<<<<<<< HEAD
    @GetMapping("/{candidateId}")
    public ResponseEntity<List<RecommendationResponse>> getRecommendations(
            @PathVariable Long candidateId,

            @RequestParam(defaultValue = "10")
            @Min(value = 1, message = "limit must be at least 1")
            int limit) {

        return ResponseEntity.ok(
                recommendationService.getRecommendations(
                        candidateId,
                        limit
                )
        );
=======
    @GetMapping("/{candidateId}/recommendations")
    public List<RecommendationResponse> getRecommendations(
            @PathVariable Long candidateId,
            @RequestParam(defaultValue = "5") int limit) {

        return recommendationService.getRecommendations(
                candidateId,
                limit);
>>>>>>> 5cfc5c5 (Implement job recommendation engine)
    }
}