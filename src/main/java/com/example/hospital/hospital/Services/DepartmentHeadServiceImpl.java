package com.example.hospital.hospital.Services;

import com.example.hospital.hospital.Models.DepartmentHead;
import com.example.hospital.hospital.Repositories.DepartmentHeadRepository;
import org.springframework.stereotype.Service;

import java.util.List;


@Service

public class DepartmentHeadServiceImpl implements DepartmentHeadService {
    private final DepartmentHeadRepository departmentHeadRepository;

    public DepartmentHeadServiceImpl(DepartmentHeadRepository departmentHeadRepository) {
        this.departmentHeadRepository = departmentHeadRepository;
    }

    @Override
    public List<DepartmentHead> getAllDepartmentHeads() {
        return departmentHeadRepository.findAll();
    }

    @Override
    public DepartmentHead getDepartmentHeadById(Long id) {
        return departmentHeadRepository.findById(id).orElse(null);
    }

    @Override
    public DepartmentHead saveDepartmentHead(DepartmentHead departmentHead) {
        return departmentHeadRepository.save(departmentHead);
    }

    @Override
    public void deleteDepartmentHead(Long id) {
        departmentHeadRepository.deleteById(id);
    }
}
