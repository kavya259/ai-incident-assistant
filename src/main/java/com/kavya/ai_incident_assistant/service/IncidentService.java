package com.kavya.ai_incident_assistant.service;
import com.kavya.ai_incident_assistant.model.Status;
import com.kavya.ai_incident_assistant.model.Severity;
import com.kavya.ai_incident_assistant.dto.CreateIncidentRequest;
import com.kavya.ai_incident_assistant.entity.Incident;
import com.kavya.ai_incident_assistant.repository.IncidentRepository;
import org.springframework.stereotype.Service;

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
    public Incident updateStatus(Long id, Status status) {
        Incident incident = repo.findById(id)
                .orElseThrow(() -> new RuntimeException("Incident not found"));

        incident.setStatus(status);
        return repo.save(incident);
    }
}