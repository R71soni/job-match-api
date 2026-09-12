package com.lernern.jobmatch.controller;

import com.lernern.jobmatch.dto.RecommendationResponse;
import com.lernern.jobmatch.service.RecommendationService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/candidates")
public class RecommendationController {

    private final RecommendationService recommendationService;

    public RecommendationController(
            RecommendationService recommendationService) {

        this.recommendationService = recommendationService;
    }

    @GetMapping("/{candidateId}/recommendations")
    public List<RecommendationResponse> getRecommendations(
            @PathVariable Long candidateId,
            @RequestParam(defaultValue = "5") int limit) {

        return recommendationService.getRecommendations(
                candidateId,
                limit);
    }
}