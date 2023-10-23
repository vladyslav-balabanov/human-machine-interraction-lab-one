package com.example.application.models;

import lombok.Data;
import lombok.experimental.Accessors;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
@Accessors(chain = true)
public class AppointmentDetails {
    private LocalDateTime datetime;
    private String description;
    private DoctorInfo doctorDetails;
    private String patientName;
    private String patientEmail;
    private String patientNumber;
    private LocalDate patientDateOfBirth;
}
