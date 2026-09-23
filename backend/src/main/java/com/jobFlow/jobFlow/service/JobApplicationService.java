package com.jobFlow.jobFlow.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.jobFlow.jobFlow.exception.ApplicationNotFoundException;
import com.jobFlow.jobFlow.model.JobApplication;
import com.jobFlow.jobFlow.repository.JobApplicationRepository;

@Service 
public class JobApplicationService{

    private final JobApplicationRepository repository;

    public JobApplicationService(JobApplicationRepository repository) {
        this.repository = repository;
    }

    public List<JobApplication> findAll(){
        return repository.findAll();
    }

    public JobApplication findById(Long id){

        Optional<JobApplication> result = repository.findById(id);

        if (result.isEmpty()) {
            throw new ApplicationNotFoundException(
                "No existe ninguna candidatura con el id " + id
            );
        }

        return result.get();
    }

    public JobApplication createApplication(JobApplication application){

        
        if (application.getCompany() == null ||
            application.getCompany().isBlank()) {

            throw new IllegalArgumentException(
                "La empresa es obligatoria"
            );
        }

        if (application.getPosition() == null ||
            application.getPosition().isBlank()) {

            throw new IllegalArgumentException(
                "El puesto es obligatorio"
                );
        }

        application.setId(null);

        return repository.save(application);
    }

    public JobApplication updateApplication(Long id, JobApplication application){

        JobApplication result = findById(id);

        if (application.getCompany() == null ||
            application.getCompany().isBlank()) {

            throw new IllegalArgumentException(
                "La empresa es obligatoria"
            );
        }

        if (application.getPosition() == null ||
            application.getPosition().isBlank()) {

            throw new IllegalArgumentException(
                "El puesto es obligatorio"
                );
        }

        result.setCompany(application.getCompany());
        result.setAppliedDate(application.getAppliedDate());
        result.setJobUrl(application.getJobUrl());
        result.setLocation(application.getLocation());
        result.setModality(application.getModality());
        result.setNotes(application.getNotes());
        result.setPosition(application.getPosition());
        result.setStatus(application.getStatus());

        return repository.save(result);

    }

    public void deleteApplication(Long id){

        JobApplication application = findById(id);

        repository.delete(application);
    }

} 