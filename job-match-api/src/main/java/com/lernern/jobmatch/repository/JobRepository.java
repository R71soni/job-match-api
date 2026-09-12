package com.lernern.jobmatch.repository;

import com.lernern.jobmatch.entity.Job;
import org.springframework.data.jpa.repository.JpaRepository;

public interface JobRepository extends JpaRepository<Job, Long> {
}