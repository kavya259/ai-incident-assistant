package com.kavya.ai_incident_assistant.controller;

import com.kavya.ai_incident_assistant.dto.CreateIncidentRequest;
import com.kavya.ai_incident_assistant.entity.Incident;
import com.kavya.ai_incident_assistant.model.Status;
import com.kavya.ai_incident_assistant.service.IncidentService;
import jakarta.validation.Valid;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import com.kavya.ai_incident_assistant.model.Severity;
import org.springframework.data.domain.PageRequest;
@RestController
@RequestMapping("/api/incidents")
public class IncidentController {

    private final IncidentService service;

    public IncidentController(IncidentService service) {
        this.service = service;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Incident create(@Valid @RequestBody CreateIncidentRequest req) {
        return service.create(req);
    }

    @GetMapping
    public Page<Incident> list(
            @RequestParam(required = false) Status status,
            @RequestParam(required = false) Severity severity,
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "5") int size
    ) {
        return service.getFiltered(status, severity, PageRequest.of(page, size));
    }

    @GetMapping("/{id}")
    public Incident getById(@PathVariable Long id) {
        return service.getById(id);
    }

    @PutMapping("/{id}/status")
    public Incident updateStatus(
            @PathVariable Long id,
            @RequestParam Status status) {
        return service.updateStatus(id, status);
    }
}