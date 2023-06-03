package com.prooutsourcingng.jobs.service;

import com.prooutsourcingng.jobs.payload.ApplicationDto;

import java.util.List;

public interface ApplicationService {
    ApplicationDto createApplication(long job_id, ApplicationDto applicationDto);

    List<ApplicationDto> getApplicationsByJobId(long job_Id);
}
