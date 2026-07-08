package com.kavya.ai_incident_assistant.service;
import com.kavya.ai_incident_assistant.model.Status;
import com.kavya.ai_incident_assistant.model.Severity;
import com.kavya.ai_incident_assistant.dto.CreateIncidentRequest;
import com.kavya.ai_incident_assistant.entity.Incident;
import com.kavya.ai_incident_assistant.repository.IncidentRepository;
import org.springframework.stereotype.Service;
import com.kavya.ai_incident_assistant.exception.ResourceNotFoundException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import com.kavya.ai_incident_assistant.model.Status;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

@Service
public class IncidentService {

    private final IncidentRepository repo;

    public IncidentService(IncidentRepository repo) {
        this.repo = repo;
    }

    public Incident create(CreateIncidentRequest req) {
        Incident incident = new Incident();
        incident.setTitle(req.getTitle());
        incident.setDescription(req.getDescription());

        if (req.getSeverity() != null) incident.setSeverity(req.getSeverity());
        if (req.getStatus() != null) incident.setStatus(req.getStatus());

        return repo.save(incident);
    }

    public Incident getById(Long id) {
        return repo.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Incident not found with id " + id));
    }

    public Incident updateStatus(Long id, Status status) {
        Incident incident = repo.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Incident not found with id " + id));

        incident.setStatus(status);
        return repo.save(incident);
    }
    public Page<Incident> list(Status status, Pageable pageable) {
        if (status != null) {
            return repo.findByStatus(status, pageable);
        }
        return repo.findAll(pageable);
    }
    public Page<Incident> getFiltered(Status status, Severity severity, Pageable pageable) {
        if (status != null && severity != null) {
            return repo.findByStatusAndSeverity(status, severity, pageable);
        }
        if (status != null) {
            return repo.findByStatus(status, pageable);
        }
        if (severity != null) {
            return repo.findBySeverity(severity, pageable);
        }
        return repo.findAll(pageable);
    }
}