package edu.icet.service.impl;

import edu.icet.dto.Appointment;
import edu.icet.entity.AppointmentEntity;
import edu.icet.repository.AppointmentRepository;
import edu.icet.service.AppointmentService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor

public class AppointmentServiceImpl implements AppointmentService {

    final AppointmentRepository repository;
    final ModelMapper mapper;

    @Override
    public void addAppointment(Appointment appointment) {
        repository.save(mapper.map(appointment, AppointmentEntity.class));
    }

    @Override
    public List<Appointment> getAppointment() {
        List<Appointment>appointments=new ArrayList<>();
        repository.findAll().forEach(appointmentEntity -> appointments.add(mapper.map(appointmentEntity, Appointment.class)));
        return appointments;
    }
}
