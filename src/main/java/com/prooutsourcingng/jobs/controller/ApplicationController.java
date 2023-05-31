package com.prooutsourcingng.jobs.controller;

import com.prooutsourcingng.jobs.payload.ApplicationDto;
import com.prooutsourcingng.jobs.service.ApplicationService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/jobs/{job_id}/applications")
public class ApplicationController {

    private ApplicationService applicationService;

    public ApplicationController(ApplicationService applicationService) {
        this.applicationService = applicationService;
    }

    // Create Job-Application REST-APIs
    @PostMapping
    public ResponseEntity<ApplicationDto> createApplication(@PathVariable(value = "job_id") long job_id,
                                                            @RequestBody ApplicationDto applicationDto) {
        return  new ResponseEntity<>(applicationService.createApplication(job_id, applicationDto), HttpStatus.CREATED);
    }
}
