package com.jobFlow.jobFlow.repository;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.jobFlow.jobFlow.model.JobApplication;

@Repository 
public class JobAplicationRepository {

    private final List<JobApplication> applications = new ArrayList<>();

    public List<JobApplication> findAll(){

        return applications;
    }

    public JobApplication findById(Long id){

        for(JobApplication app : applications){
            if (app.getId().equals(id)) {
                return app;
            }
        }

        return null;
    }

    public JobApplication save(JobApplication application){

        applications.add(application);

        return application;
    }
    
}
