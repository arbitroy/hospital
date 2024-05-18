package com.example.hospital.hospital.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.hospital.hospital.Models.DepartmentHead;

@Repository
public interface DepartmentHeadRepository extends JpaRepository<DepartmentHead, Long> {

}
