package com.example.hospital.hospital.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.hospital.hospital.Models.Patient;

@Repository
public interface PatientRepository extends JpaRepository<Patient,Long > {

}
