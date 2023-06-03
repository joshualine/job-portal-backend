package com.prooutsourcingng.jobs.controller;

import com.prooutsourcingng.jobs.payload.ApplicationDto;
import com.prooutsourcingng.jobs.service.ApplicationService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/jobs/{job_id}/applications")
public class ApplicationController {

    private ApplicationService applicationService;

    public ApplicationController(ApplicationService applicationService) {
        this.applicationService = applicationService;
    }

    // Create Application for a given Job
    @PostMapping
    public ResponseEntity<ApplicationDto> createApplication(@PathVariable(value = "job_id") long job_id,
                                                            @RequestBody ApplicationDto applicationDto) {
        return  new ResponseEntity<>(applicationService.createApplication(job_id, applicationDto), HttpStatus.CREATED);
    }

    // Get all Applications for a given Job
    @PreAuthorize("hasRole('ADMIN')")
    @GetMapping
    public List<ApplicationDto> getApplicationsByJobId(@PathVariable(value = "job_id") Long job_id) {
        return applicationService.getApplicationsByJobId(job_id);
    }
}
