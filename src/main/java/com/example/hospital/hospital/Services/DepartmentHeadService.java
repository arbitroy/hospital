package com.example.hospital.hospital.Services;
import com.example.hospital.hospital.Models.DepartmentHead;

import java.util.List;

public interface DepartmentHeadService {
    List<DepartmentHead> getAllDepartmentHeads();
    DepartmentHead getDepartmentHeadById(Long id);
    DepartmentHead saveDepartmentHead(DepartmentHead departmentHead);
    void deleteDepartmentHead(Long id);
}