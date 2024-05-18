package com.example.hospital.hospital.Controllers;

import com.example.hospital.hospital.Models.DepartmentHead;
import com.example.hospital.hospital.Services.DepartmentHeadService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/department-heads")
public class DepartmentHeadController {
    private final DepartmentHeadService departmentHeadService;

    public DepartmentHeadController(DepartmentHeadService departmentHeadService) {
        this.departmentHeadService = departmentHeadService;
    }

    @GetMapping
    public List<DepartmentHead> getAllDepartmentHeads() {
        return departmentHeadService.getAllDepartmentHeads();
    }

    @GetMapping("/{id}")
    public ResponseEntity<DepartmentHead> getDepartmentHeadById(@PathVariable Long id) {
        DepartmentHead departmentHead = departmentHeadService.getDepartmentHeadById(id);
        return departmentHead != null ? ResponseEntity.ok(departmentHead) : ResponseEntity.notFound().build();
    }

    @PostMapping
    public DepartmentHead createDepartmentHead(@RequestBody DepartmentHead departmentHead) {
        return departmentHeadService.saveDepartmentHead(departmentHead);
    }

    @PutMapping("/{id}")
    public ResponseEntity<DepartmentHead> updateDepartmentHead(@PathVariable Long id, @RequestBody DepartmentHead departmentHeadDetails) {
        DepartmentHead departmentHead = departmentHeadService.getDepartmentHeadById(id);
        if (departmentHead == null) {
            return ResponseEntity.notFound().build();
        }
        departmentHead.setName(departmentHeadDetails.getName());
        departmentHeadService.saveDepartmentHead(departmentHead);
        return ResponseEntity.ok(departmentHead);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<HttpStatus> deleteDepartmentHead(@PathVariable Long id) {
        departmentHeadService.deleteDepartmentHead(id);
        return ResponseEntity.noContent().build();
    }
}