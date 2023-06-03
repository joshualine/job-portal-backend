package com.prooutsourcingng.jobs.repository;

import com.prooutsourcingng.jobs.entity.Application;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ApplicationRepository extends JpaRepository<Application, Long> {

    List<Application> findByJobId(long job_id);
}
