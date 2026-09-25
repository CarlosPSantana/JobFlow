package com.jobFlow.jobFlow.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.jobFlow.jobFlow.dto.JobApplicationRequest;
import com.jobFlow.jobFlow.dto.JobApplicationResponse;
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

    public List<JobApplicationResponse> findAllResponse(){
        
        List<JobApplication> applications = repository.findAll();
        List<JobApplicationResponse> responses = new ArrayList<>();
        

        for(JobApplication app : applications){
            JobApplicationResponse response = toResponse(app);

            responses.add(response);
        }

        return responses;
    } 

    public JobApplication findById(Long id){

        return repository.findById(id)
            .orElseThrow(() -> new ApplicationNotFoundException(
                    "No existe ninguna candidatura con el ID " + id
            ));
    }

    public JobApplicationResponse findResponseById(Long id){

        JobApplication entity = findById(id);

        return toResponse(entity);

    }

    public JobApplicationResponse createApplication(JobApplicationRequest application){

        JobApplication entity = toEntity(application);

        repository.save(entity);

        JobApplicationResponse response = toResponse(entity);

        return response;
    }

    public JobApplicationResponse updateApplication(Long id, JobApplicationRequest request){

        JobApplication existing = findById(id);
        
        existing.setCompany(request.getCompany());
        existing.setAppliedDate(request.getAppliedDate());
        existing.setJobUrl(request.getJobUrl());
        existing.setLocation(request.getLocation());
        existing.setModality(request.getModality());
        existing.setNotes(request.getNotes());
        existing.setPosition(request.getPosition());
        existing.setStatus(request.getStatus());

        repository.save(existing);

        return toResponse(existing);

    }

    public void deleteApplication(Long id){

        JobApplication application = findById(id);

        repository.delete(application);
    }

    private JobApplication toEntity(JobApplicationRequest request) {

        JobApplication application = new JobApplication();

        application.setCompany(request.getCompany());
        application.setPosition(request.getPosition());
        application.setJobUrl(request.getJobUrl());
        application.setLocation(request.getLocation());
        application.setModality(request.getModality());
        application.setStatus(request.getStatus());
        application.setAppliedDate(request.getAppliedDate());
        application.setNotes(request.getNotes());

        return application;
    }

    private JobApplicationResponse toResponse(JobApplication application) {

        JobApplicationResponse response = new JobApplicationResponse();

        response.setId(application.getId());
        response.setCompany(application.getCompany());
        response.setPosition(application.getPosition());
        response.setJobUrl(application.getJobUrl());
        response.setLocation(application.getLocation());
        response.setModality(application.getModality());
        response.setStatus(application.getStatus());
        response.setAppliedDate(application.getAppliedDate());
        response.setNotes(application.getNotes());

        return response;
    }

} 