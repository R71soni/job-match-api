package com.lernern.jobmatch.controller;

import com.lernern.jobmatch.entity.Candidate;
import com.lernern.jobmatch.service.CandidateService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/candidates")
public class CandidateController {

    private final CandidateService candidateService;

    public CandidateController(CandidateService candidateService) {
        this.candidateService = candidateService;
    }

    @PostMapping
    public ResponseEntity<Candidate> createCandidate(
            @RequestBody Candidate candidate) {

        Candidate savedCandidate =
                candidateService.createCandidate(candidate);

        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(savedCandidate);
    }
}