package com.jobFlow.jobFlow.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.jobFlow.jobFlow.exception.ApplicationNotFoundException;
import com.jobFlow.jobFlow.model.JobApplication;
import com.jobFlow.jobFlow.repository.JobAplicationRepository;;

@Service 
public class JobApplicationService{

    private final JobAplicationRepository repository;

    public JobApplicationService(JobAplicationRepository repository) {
        this.repository = repository;
    }

    public List<JobApplication> findAll(){
        return repository.findAll();
    }

    public JobApplication findById(Long id){
        JobApplication application = repository.findById(id);

        if (application == null) {
            throw new ApplicationNotFoundException(
                "No existe ninguna candidatura con el id " + id
        );
    }

    return application;
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

            if (application.getId() == null) {
                throw new IllegalArgumentException(
                    "El identificador es obligatorio"
                    );
            }

        if (repository.findById(application.getId()) != null) {
            throw new IllegalArgumentException(
                "Ya existe una candidatura con ese ID"
            );
        }

        return repository.save(application);
        }

}