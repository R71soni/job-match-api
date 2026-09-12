package com.lernern.jobmatch.repository;

import com.lernern.jobmatch.entity.Candidate;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CandidateRepository extends JpaRepository<Candidate, Long> {
}