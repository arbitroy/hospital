package com.example.hospital.hospital.Services;

import com.example.hospital.hospital.Models.Appointment;

import java.util.List;

public interface AppointmentService {
    List<Appointment> getAllAppointments();
    Appointment getAppointmentById(Long id);
    Appointment saveAppointment(Appointment appointment);
    void deleteAppointment(Long id);
}