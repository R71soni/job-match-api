package com.lernern.jobmatch.service;

import com.lernern.jobmatch.entity.Candidate;
import com.lernern.jobmatch.repository.CandidateRepository;
import org.springframework.stereotype.Service;

@Service
public class CandidateService {

    private final CandidateRepository candidateRepository;

    public CandidateService(CandidateRepository candidateRepository) {
        this.candidateRepository = candidateRepository;
    }

    public Candidate createCandidate(Candidate candidate) {
        return candidateRepository.save(candidate);
    }
}