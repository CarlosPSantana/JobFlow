package com.jobFlow.jobFlow.controller;


import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jobFlow.jobFlow.dto.JobApplicationRequest;
import com.jobFlow.jobFlow.dto.JobApplicationResponse;
import com.jobFlow.jobFlow.model.JobApplication;
import com.jobFlow.jobFlow.service.JobApplicationService;

import jakarta.validation.Valid;

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
    public ResponseEntity<List<JobApplicationResponse>> getApplications() {
        
        List<JobApplicationResponse> responses = service.findAllResponse();

        return ResponseEntity.ok(responses);

    }

    @GetMapping("/{id}")
    public ResponseEntity<JobApplicationResponse> getApplicationById(@PathVariable Long id) {
        JobApplicationResponse response =  service.findResponseById(id);

        return ResponseEntity.ok(response);
    }

    @PostMapping
    public ResponseEntity<JobApplicationResponse> postApplication(@Valid @RequestBody JobApplicationRequest application) {
        
        JobApplicationResponse created = service.createApplication(application);

        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(created);
    }

    @PutMapping("/{id}")
    public ResponseEntity<JobApplicationResponse> putApplication(@PathVariable Long id, @Valid @RequestBody JobApplicationRequest application) {
        
        JobApplicationResponse updated = service.updateApplication(id, application);

        return ResponseEntity
                .ok(updated);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<JobApplication> deleteApplication(@PathVariable Long id){
        
        service.deleteApplication(id);

        return ResponseEntity.noContent().build();
    }
    
    
    
}