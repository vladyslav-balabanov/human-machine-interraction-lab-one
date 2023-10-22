package com.example.application.models;

import lombok.Data;
import lombok.experimental.Accessors;

import java.time.LocalDateTime;

@Data
@Accessors(chain = true)
public class AppointmentDetails {
    private LocalDateTime datetime;
    private String description;
    private DoctorInfo doctorDetails;
}
