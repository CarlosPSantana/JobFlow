package com.jobFlow.jobFlow.model;

import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

@Entity 
@Table(name = "job_application") 
public class JobApplication {
    
    @Id 
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "La empresa es obligatoria.")
    @Size(max = 150, message = "La empresa no debe superar los 150 caracteres.")
    private String company;

    @NotBlank(message = "La posición es obligatoria.")
    @Size(max = 150, message = "La posición no debe superar los 150 caracteres.")
    private String position;

    @Column (name = "job_url")
    @Size(max = 500, message = "La url no debe superar los 500 caracteres.")
    private String jobUrl;

    @Size(message = "La localización no debe superar los 150 caracteres.")
    private String location;

    @Enumerated (EnumType.STRING)
    private WorkModality modality;
    
    @Enumerated (EnumType.STRING)
    @NotNull(message = "El status es esencial.")  
    private ApplicationStatus status;

    @Column (name = "applied_date")
    private LocalDate appliedDate;

    private String notes;

    public JobApplication() {
    }


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
