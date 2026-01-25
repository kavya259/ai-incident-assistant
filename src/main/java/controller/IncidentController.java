package com.kavya.ai_incident_assistant.controller;

import com.kavya.ai_incident_assistant.entity.Incident;
import com.kavya.ai_incident_assistant.repository.IncidentRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/incidents")
public class IncidentController {

    private final IncidentRepository incidentRepository;

    public IncidentController(IncidentRepository incidentRepository) {
        this.incidentRepository = incidentRepository;
    }

    // ✅ GET all incidents
    @GetMapping
    public List<Incident> getAll() {
        return incidentRepository.findAll();
    }
}
