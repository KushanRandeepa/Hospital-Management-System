package edu.icet.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
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
@Entity

public class AppointmentEntity {
    @Id
    private String id;
    private String type;
    private String qr;
    private String description;
    private String status;
    private Integer roomNumber;
    private Integer queNumber;
    private String patientId;
    private String appointmentDate;
    private String appointmentTime;


}
