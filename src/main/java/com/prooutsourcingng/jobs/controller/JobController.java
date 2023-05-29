package com.prooutsourcingng.jobs.controller;

import com.prooutsourcingng.jobs.payload.JobDto;
import com.prooutsourcingng.jobs.service.JobService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/jobs")
public class JobController {

    private JobService jobService;

    public JobController(JobService jobService) {
        this.jobService = jobService;
    }

    //Create Job REST-API
    @PostMapping
    public ResponseEntity<JobDto> createJob(@RequestBody JobDto jobDto){
        return new ResponseEntity<>(jobService.createJob(jobDto), HttpStatus.CREATED);
    }

    //Get all Jobs REST-API
    @GetMapping
    public List<JobDto> getAllJobs() {
        return jobService.getAllJobs();
    }
}