package com.kavya.ai_incident_assistant.dto;

import com.kavya.ai_incident_assistant.model.Severity;
import com.kavya.ai_incident_assistant.model.Status;
import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CreateIncidentRequest {

    @NotBlank
    private String title;

    private String description;

    private Severity severity;  // changed from String
    private Status status;      // changed from String
}