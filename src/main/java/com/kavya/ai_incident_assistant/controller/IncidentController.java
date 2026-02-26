package com.kavya.ai_incident_assistant.controller;
import com.kavya.ai_incident_assistant.model.Status;
import com.kavya.ai_incident_assistant.dto.CreateIncidentRequest;
import com.kavya.ai_incident_assistant.entity.Incident;
import com.kavya.ai_incident_assistant.repository.IncidentRepository;
import com.kavya.ai_incident_assistant.service.IncidentService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/incidents")
public class IncidentController {

    private final IncidentService service;
    private final IncidentRepository repo;

    public IncidentController(IncidentService service, IncidentRepository repo) {
        this.service = service;
        this.repo = repo;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Incident create(@Valid @RequestBody CreateIncidentRequest req) {
        return service.create(req);
    }

    @GetMapping
    public List<Incident> list() {
        return repo.findAll();
    }

    @PutMapping("/{id}/status")
    public Incident updateStatus(
            @PathVariable Long id,
            @RequestParam Status status) {
        return service.updateStatus(id, status);
    }
}