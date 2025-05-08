package edu.icet.controller;

import edu.icet.dto.Appointment;
import edu.icet.service.AppointmentService;
import jakarta.persistence.GeneratedValue;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/appointment")

public class AppointmentController {

    final AppointmentService service;

    @PostMapping("/add-appointment")
    @ResponseStatus(HttpStatus.CREATED)
    public void addAppointment(@RequestBody Appointment appointment){
        service.addAppointment(appointment);
    }
    @GetMapping("/get-all")
    public List<Appointment> getAllAppointment(){
          return service.getAppointment();
    }
}
