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

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PutMapping;


@Tag(
    name = "Job Applications",
    description = "Gestión de candidaturas de empleo"
)
@RestController 
@RequestMapping ("/api/applications")
public class jobApplicationController {
    private final JobApplicationService service;

    public jobApplicationController(JobApplicationService service) {
        this.service = service;
    }

    @Operation(
    summary = "Obtener todas las candidatura",
    description = "Devuelve todas las candidaturas candidaturas.")
    @ApiResponse(
        responseCode = "200",
        description = "Candidaturas encontradas"
    )

    @GetMapping
    public ResponseEntity<List<JobApplicationResponse>> getApplications() {
        
        List<JobApplicationResponse> responses = service.findAllResponse();

        return ResponseEntity.ok(responses);

    }

    @Operation(
    summary = "Obtener una candidatura por ID",
    description = "Devuelve una candidatura concreta a partir de su identificador.")

    @ApiResponses({
    @ApiResponse(
        responseCode = "200",
        description = "Candidatura encontrada"
    ),
    @ApiResponse(
        responseCode = "404",
        description = "Candidatura no encontrada"
    )})

    @GetMapping("/{id}")
    public ResponseEntity<JobApplicationResponse> getApplicationById(@PathVariable Long id) {
        JobApplicationResponse response =  service.findResponseById(id);

        return ResponseEntity.ok(response);
    }

    @Operation(
    summary = "Crear una candidatura",
    description = "Devuelve la candidatura que hayamos creado.")

    @ApiResponses({
    @ApiResponse(
        responseCode = "201",
        description = "Candidatura creada"
    ),
    @ApiResponse(
        responseCode = "400",
        description = "Credenciales incorrectas"
    )})

    @PostMapping
    public ResponseEntity<JobApplicationResponse> postApplication(@Valid @RequestBody JobApplicationRequest application) {
        
        JobApplicationResponse created = service.createApplication(application);

        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(created);
    }

    @Operation(
    summary = "Actualizar una candidatura por ID",
    description = "Devuelve una candidatura concreta actualizada con los parametros especificados.")

    @ApiResponses({
    @ApiResponse(
        responseCode = "200",
        description = "Candidatura encontrada"
    ),
    @ApiResponse(
        responseCode = "400",
        description = "Petición incorrecta."
    ),
    @ApiResponse(
        responseCode = "404",
        description = "Candidatura no encontrada"
    )})

    @PutMapping("/{id}")
    public ResponseEntity<JobApplicationResponse> putApplication(@PathVariable Long id, @Valid @RequestBody JobApplicationRequest application) {
        
        JobApplicationResponse updated = service.updateApplication(id, application);

        return ResponseEntity
                .ok(updated);
    }

    @Operation(
    summary = "Eliminar una candidatura por ID",
    description = "Devuelve la respuesta a dicha petición.")

    @ApiResponses({
    @ApiResponse(
        responseCode = "204",
        description = "Candidatura eliminada"
    ),
    @ApiResponse(
        responseCode = "404",
        description = "Candidatura no encontrada"
    )})

    @DeleteMapping("/{id}")
    public ResponseEntity<JobApplication> deleteApplication(@PathVariable Long id){
        
        service.deleteApplication(id);

        return ResponseEntity.noContent().build();
    }
    
    
    
}