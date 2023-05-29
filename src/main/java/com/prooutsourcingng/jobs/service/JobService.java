package com.prooutsourcingng.jobs.service;

import com.prooutsourcingng.jobs.payload.JobDto;

import java.util.List;

public interface JobService{
    JobDto createJob(JobDto jobDto);

    List<JobDto> getAllJobs();
}