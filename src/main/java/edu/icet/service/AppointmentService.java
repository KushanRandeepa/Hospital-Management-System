package edu.icet.service;

import edu.icet.dto.Appointment;

import java.util.List;

public interface AppointmentService {

    void addAppointment(Appointment appointment);

    List<Appointment> getAppointment();
}
