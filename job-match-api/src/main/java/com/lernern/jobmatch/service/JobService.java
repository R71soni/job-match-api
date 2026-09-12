package com.lernern.jobmatch.service;

import com.lernern.jobmatch.entity.Job;
<<<<<<< HEAD
import com.lernern.jobmatch.exception.JobNotFoundException;
=======
>>>>>>> d5e521b (Add job creation API)
import com.lernern.jobmatch.repository.JobRepository;
import org.springframework.stereotype.Service;

@Service
public class JobService {

    private final JobRepository jobRepository;

    public JobService(JobRepository jobRepository) {
        this.jobRepository = jobRepository;
    }

    public Job createJob(Job job) {
        return jobRepository.save(job);
    }
<<<<<<< HEAD

    public Job getJobById(Long id) {

        return jobRepository.findById(id)
                .orElseThrow(() ->
                        new JobNotFoundException(
                                "Job not found with id: " + id
                        )
                );
    }
=======
>>>>>>> d5e521b (Add job creation API)
}