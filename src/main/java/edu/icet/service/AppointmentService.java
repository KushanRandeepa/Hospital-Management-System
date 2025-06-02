package edu.icet.service;

import edu.icet.dto.Appointment;

import java.time.LocalDate;

import java.time.LocalDateTime;
import java.util.List;

public interface AppointmentService {

    void addAppointment(Appointment appointment);

    List<Appointment> getAppointment();

    Boolean deleteAppointment(String id);

    Appointment searchById(String id);

    List<Appointment> searchByRoomNumber(Integer roomNumber);

    List<Appointment> searchByQueNumber(Integer queNumber);

    List<Appointment> searchByPatientId(String patientID);


    void updateAppointment(Appointment appointment);
}
