package com.jobFlow.jobFlow.model;

import java.time.LocalDate;

public class JobApplication {
    
    private Long id;
    private String company;
    private String position;
    private String jobUrl;
    private String location;
    private WorkModality modality;
    private ApplicationStatus status;
    private LocalDate appliedDate;
    private String notes;

    public JobApplication(Long id, String company, String position, String jobUrl, String location,
            WorkModality modality, ApplicationStatus status, LocalDate appliedDate, String notes) {
        this.id = id;
        this.company = company;
        this.position = position;
        this.jobUrl = jobUrl;
        this.location = location;
        this.modality = modality;
        this.status = status;
        this.appliedDate = appliedDate;
        this.notes = notes;
    }

    
    public Long getId() {
        return id;
    }


    public void setId(Long id) {
        this.id = id;
    }


    public String getCompany() {
        return company;
    }


    public void setCompany(String company) {
        this.company = company;
    }


    public String getPosition() {
        return position;
    }


    public void setPosition(String position) {
        this.position = position;
    }


    public String getJobUrl() {
        return jobUrl;
    }


    public void setJobUrl(String jobUrl) {
        this.jobUrl = jobUrl;
    }


    public String getLocation() {
        return location;
    }


    public void setLocation(String location) {
        this.location = location;
    }


    public WorkModality getModality() {
        return modality;
    }


    public void setModality(WorkModality modality) {
        this.modality = modality;
    }


    public ApplicationStatus getStatus() {
        return status;
    }


    public void setStatus(ApplicationStatus status) {
        this.status = status;
    }


    public LocalDate getAppliedDate() {
        return appliedDate;
    }


    public void setAppliedDate(LocalDate appliedDate) {
        this.appliedDate = appliedDate;
    }


    public String getNotes() {
        return notes;
    }


    public void setNotes(String notes) {
        this.notes = notes;
    }


    
}
