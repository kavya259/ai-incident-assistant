package com.kavya.ai_incident_assistant.dto;

import com.kavya.ai_incident_assistant.model.Severity;
import com.kavya.ai_incident_assistant.model.Status;
import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CreateIncidentRequest {

    @NotBlank(message = "title is required")
    private String title;

    private String description;

    private Severity severity;
    private Status status;
}