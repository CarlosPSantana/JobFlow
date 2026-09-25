package com.jobFlow.jobFlow.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.jobFlow.jobFlow.dto.JobApplicationRequest;
import com.jobFlow.jobFlow.dto.JobApplicationResponse;
import com.jobFlow.jobFlow.exception.ApplicationNotFoundException;
import com.jobFlow.jobFlow.model.ApplicationStatus;
import com.jobFlow.jobFlow.model.JobApplication;
import com.jobFlow.jobFlow.repository.JobApplicationRepository;

public class JobApplicationServiceTest {

    @Mock
    private JobApplicationRepository repository;

    private JobApplicationService service;

    @BeforeEach
    void setUp() {

        MockitoAnnotations.openMocks(this);

        service = new JobApplicationService(repository);
    }

    @Test
    void shouldReturnApplicationWhenIdExists() {

        JobApplication application = new JobApplication();

        application.setId(1L);
        application.setCompany("DXC");
        application.setPosition("Java Junior");
        application.setStatus(ApplicationStatus.APPLIED);

        when(repository.findById(1L))
                .thenReturn(Optional.of(application));

        JobApplicationResponse response =
                service.findResponseById(1L);

        assertEquals(1L, response.getId());
        assertEquals("DXC", response.getCompany());
        assertEquals("Java Junior", response.getPosition());
        assertEquals(ApplicationStatus.APPLIED, response.getStatus());
    }

    @Test
    void shouldThrowExceptionWhenIdDoesNotExist() {

        when(repository.findById(999L))
                .thenReturn(Optional.empty());

        assertThrows(
                ApplicationNotFoundException.class,
                () -> service.findResponseById(999L)
        );
    }

    @Test
    void shouldCreateApplication() {

        JobApplicationRequest request = new JobApplicationRequest();
        request.setCompany("Binter");
        request.setPosition("Java Junior");
        request.setStatus(ApplicationStatus.APPLIED);

        JobApplication savedApplication = new JobApplication();
        savedApplication.setId(10L);
        savedApplication.setCompany("Binter");
        savedApplication.setPosition("Java Junior");
        savedApplication.setStatus(ApplicationStatus.APPLIED);

        when(repository.save(
                org.mockito.ArgumentMatchers.any(JobApplication.class)))
                .thenReturn(savedApplication);

        JobApplicationResponse response =
                service.createApplication(request);

        assertEquals(10L, response.getId());
        assertEquals("Binter", response.getCompany());

        verify(repository, times(1))
                .save(org.mockito.ArgumentMatchers.any(JobApplication.class));
    }

    @Test
    void shouldDeleteApplicationWhenIdExists() {

        JobApplication application = new JobApplication();
        application.setId(5L);
        application.setCompany("Empresa prueba");
        application.setPosition("Java Junior");

        when(repository.findById(5L))
                .thenReturn(Optional.of(application));

        service.deleteApplication(5L);

        verify(repository).delete(application);
    }

}