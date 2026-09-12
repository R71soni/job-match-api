package com.lernern.jobmatch.controller;

import com.lernern.jobmatch.entity.Job;
import com.lernern.jobmatch.service.JobService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/jobs")
public class JobController {

    private final JobService jobService;

    public JobController(JobService jobService) {
        this.jobService = jobService;
    }

    @PostMapping
    public ResponseEntity<Job> createJob(
            @RequestBody Job job) {

        Job savedJob = jobService.createJob(job);

        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(savedJob);
    }
}