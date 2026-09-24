package com.jobFlow.jobFlow.dto;

import java.time.LocalDate;

import com.jobFlow.jobFlow.model.ApplicationStatus;
import com.jobFlow.jobFlow.model.WorkModality;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public class JobApplicationResponse {

    private Long id;
    @NotBlank(message = "La empresa es obligatoria.")
    @Size(max = 150, message = "La empresa no debe superar los 150 caracteres.")
    private String company;

    @NotBlank(message = "La posición es obligatoria.")
    @Size(max = 150, message = "La posición no debe superar los 150 caracteres.")
    private String position;


    @Size(max = 500, message = "La url no debe superar los 500 caracteres.")
    private String jobUrl;

    @Size(message = "La localización no debe superar los 150 caracteres.")
    private String location;
    
    private WorkModality modality;

    @NotNull(message = "El status es esencial.")  
    private ApplicationStatus status;

    private LocalDate appliedDate;
    private String notes;

    
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
