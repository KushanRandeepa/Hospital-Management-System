package edu.icet.dto;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString

public class Appointment {
    private String id;
    private String type;
    private String qr;
  private String description;
    private String status;
    private Integer roomNumber;
    private Integer queNumber;
    private String patientId;
    private String adminId;
    private String appointmentDate;
    private String appointmentTime;
}
