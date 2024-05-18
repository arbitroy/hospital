package com.example.hospital.hospital.Repositories;

import com.example.hospital.hospital.Models.Appointment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface AppointmentRepository extends JpaRepository<Appointment, Long> {
    // You can add custom queries here if needed
}