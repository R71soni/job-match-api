package com.lernern.jobmatch.dto;

import com.lernern.jobmatch.entity.Job;

public class JobResponse {

    private Long id;
    private String title;
    private String location;
    private int minYearsExperience;
    private boolean remoteAllowed;

    public JobResponse(Job job) {
        this.id = job.getId();
        this.title = job.getTitle();
        this.location = job.getLocation();
        this.minYearsExperience = job.getMinYearsExperience();
        this.remoteAllowed = job.isRemoteAllowed();
    }

    public Long getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getLocation() {
        return location;
    }

    public int getMinYearsExperience() {
        return minYearsExperience;
    }

    public boolean isRemoteAllowed() {
        return remoteAllowed;
    }
}