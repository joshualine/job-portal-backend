package com.prooutsourcingng.jobs.service.impl;

import com.prooutsourcingng.jobs.entity.Application;
import com.prooutsourcingng.jobs.entity.Job;
import com.prooutsourcingng.jobs.exception.ResourceNotFoundException;
import com.prooutsourcingng.jobs.payload.ApplicationDto;
import com.prooutsourcingng.jobs.repository.ApplicationRepository;
import com.prooutsourcingng.jobs.repository.JobRepository;
import com.prooutsourcingng.jobs.service.ApplicationService;
import org.springframework.stereotype.Service;

@Service
public class ApplicationServiceImpl implements ApplicationService {

    private ApplicationRepository applicationRepository;
    private JobRepository jobRepository;

    public ApplicationServiceImpl(ApplicationRepository applicationRepository, JobRepository jobRepository) {
        this.applicationRepository = applicationRepository;
        this.jobRepository = jobRepository;
    }

    @Override
    public ApplicationDto createApplication(long job_id, ApplicationDto applicationDto) {
        //Convert DTO to Entity
        Application application = mapToEntity(applicationDto);

        //retrieve Job entity by id
        Job job = jobRepository.findById(job_id).orElseThrow(() ->
                new ResourceNotFoundException("Job", "id", job_id));

        //Set Job to Application entity
        application.setJob(job);

        //Application Entity to DB
        Application newApplication = applicationRepository.save(application);
        return mapToDTO(newApplication);
    }

    //Convert DTO to Entity Method
    private Application mapToEntity(ApplicationDto applicationDto){
        Application application = new Application();
        application.setFirstName(applicationDto.getFirstName());
        application.setLastName(applicationDto.getLastName());
        application.setEmail(applicationDto.getEmail());
        application.setPhone(applicationDto.getPhone());
        application.setResume(applicationDto.getPhone());
        return application;
    }

    //Convert Entity to Dto Method
    private ApplicationDto mapToDTO(Application application) {
        ApplicationDto applicationDto = new ApplicationDto();
        applicationDto.setId(application.getId());
        applicationDto.setFirstName(application.getFirstName());
        applicationDto.setLastName(application.getLastName());
        applicationDto.setEmail(application.getEmail());
        applicationDto.setPhone(application.getPhone());
        applicationDto.setResume(application.getResume());
        return applicationDto;
    }
}
