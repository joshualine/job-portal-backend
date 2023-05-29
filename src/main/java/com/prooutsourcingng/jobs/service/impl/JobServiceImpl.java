package com.prooutsourcingng.jobs.service.impl;

import com.prooutsourcingng.jobs.entity.Job;
import com.prooutsourcingng.jobs.payload.JobDto;
import com.prooutsourcingng.jobs.repository.JobRepository;
import com.prooutsourcingng.jobs.service.JobService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class JobServiceImpl implements JobService {

    private JobRepository jobRepository;

    public JobServiceImpl(JobRepository jobRepository) {
        this.jobRepository = jobRepository;
    }

    @Override
    public JobDto createJob(JobDto jobDto) {
        //Convert DTO to Entity
        Job job = mapToEntity(jobDto);
        Job newJob = jobRepository.save(job);

        //Convert Entity to DTO
        return mapToDTO(newJob);
    }

    @Override
    public List<JobDto> getAllJobs() {
        List<Job> jobs = jobRepository.findAll();
        return jobs.stream().map(this::mapToDTO).collect(Collectors.toList());
    }

    //Convert DTO to Entity Method
    private Job mapToEntity(JobDto jobDto) {
        Job job = new Job();
        job.setTitle(jobDto.getTitle());
        job.setDescription(jobDto.getDescription());
        job.setPublished(jobDto.isPublished());
        return job;
    }

    //Convert Entity to DTO Method
    private JobDto mapToDTO(Job job) {
        JobDto jobDto = new JobDto();
        jobDto.setId(job.getId());
        jobDto.setTitle(job.getTitle());
        jobDto.setDescription((job.getDescription()));
        jobDto.setPublished(job.isPublished());
        return jobDto;
    }
}
