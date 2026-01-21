package com.kavya.ai_incident_assistant.repository;

import com.kavya.ai_incident_assistant.entity.Incident;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IncidentRepository extends JpaRepository<Incident, Long> {
}
