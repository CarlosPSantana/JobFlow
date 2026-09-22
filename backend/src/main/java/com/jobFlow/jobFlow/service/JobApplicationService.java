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

}