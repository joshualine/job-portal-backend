package com.prooutsourcingng.jobs.service;

import com.prooutsourcingng.jobs.payload.ApplicationDto;

public interface ApplicationService {
    ApplicationDto createApplication(long job_id, ApplicationDto applicationDto);
}
