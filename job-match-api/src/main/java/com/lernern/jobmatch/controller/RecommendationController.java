package com.lernern.jobmatch.controller;

import com.lernern.jobmatch.dto.RecommendationResponse;
import com.lernern.jobmatch.service.RecommendationService;
import jakarta.validation.constraints.Min;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/recommendations")
@Validated
public class RecommendationController {

    private final RecommendationService recommendationService;

    public RecommendationController(
            RecommendationService recommendationService) {

        this.recommendationService = recommendationService;
    }

    @GetMapping("/{candidateId}")
    public ResponseEntity<List<RecommendationResponse>> getRecommendations(
            @PathVariable Long candidateId,

            @RequestParam(defaultValue = "10")
            @Min(value = 1, message = "Limit must be at least 1")
            int limit) {

        return ResponseEntity.ok(
                recommendationService.getRecommendations(
                        candidateId,
                        limit
                )
        );
    }
}