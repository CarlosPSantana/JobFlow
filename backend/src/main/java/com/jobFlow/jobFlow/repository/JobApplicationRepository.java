package com.jobFlow.jobFlow.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.jobFlow.jobFlow.model.JobApplication;

public interface JobApplicationRepository
        extends JpaRepository<JobApplication, Long> {
}
