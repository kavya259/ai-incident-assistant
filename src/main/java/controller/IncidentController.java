package com.kavya.ai_incident_assistant.controller;

import com.kavya.ai_incident_assistant.entity.Incident;
import com.kavya.ai_incident_assistant.repository.IncidentRepository;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/incidents")
public class IncidentController {

    private final IncidentRepository repository;

    public IncidentController(IncidentRepository repository) {
        this.repository = repository;
    }

    @PostMapping
    public Incident createIncident(@RequestBody Incident incident) {
        return repository.save(incident);
    }
}
