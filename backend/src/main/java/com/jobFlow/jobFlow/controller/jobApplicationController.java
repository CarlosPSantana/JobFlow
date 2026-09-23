package com.jobFlow.jobFlow.controller;


import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jobFlow.jobFlow.model.JobApplication;
import com.jobFlow.jobFlow.service.JobApplicationService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PutMapping;



@RestController 
@RequestMapping ("/api/applications")
public class jobApplicationController {
    private final JobApplicationService service;

    public jobApplicationController(JobApplicationService service) {
        this.service = service;
    }

    @GetMapping
    public List<JobApplication> getApplications() {
        return service.findAll();
    }

    @GetMapping("/{id}")
    public JobApplication getApplicationById(@PathVariable Long id) {
        return service.findById(id);
    }

    @PostMapping
    public ResponseEntity<JobApplication> postApplication(@RequestBody JobApplication application) {
        JobApplication created = service.createApplication(application);

        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(created);
    }

    @PutMapping("/{id}")
    public ResponseEntity<JobApplication> putApplication(@PathVariable Long id, @RequestBody JobApplication application) {
        
        JobApplication updated = service.updateApplication(id, application);

        return ResponseEntity
                .ok(updated);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<JobApplication> deleteApplication(@PathVariable Long id){
        
        service.deleteApplication(id);

        return ResponseEntity.noContent().build();
    }
    
    
    
}