package com.kavya.ai_incident_assistant.repository;

import com.kavya.ai_incident_assistant.entity.Incident;
import com.kavya.ai_incident_assistant.model.Severity;
import com.kavya.ai_incident_assistant.model.Status;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IncidentRepository extends JpaRepository<Incident, Long> {
    Page<Incident> findByStatus(Status status, Pageable pageable);
    Page<Incident> findBySeverity(Severity severity, Pageable pageable);
    Page<Incident> findByStatusAndSeverity(Status status, Severity severity, Pageable pageable);
}