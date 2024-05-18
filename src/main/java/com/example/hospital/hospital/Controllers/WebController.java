package com.example.hospital.hospital.Controllers;

import com.example.hospital.hospital.Models.Doctor;
import com.example.hospital.hospital.Models.Patient;
import com.example.hospital.hospital.Services.DoctorService;
import com.example.hospital.hospital.Services.PatientService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class WebController {
    private final PatientService patientService;
    private final DoctorService doctorService;

    public WebController(PatientService patientService, DoctorService doctorService) {
        this.patientService = patientService;
        this.doctorService = doctorService;
    }

    @GetMapping("/")
    public String showMainMenu() {
        return "main-menu";
    }

    @GetMapping("/patients")
    public String showPatientList(Model model) {
        model.addAttribute("patients", patientService.getAllPatients());
        return "patient-list";
    }

    @GetMapping("/patients/new")
    public String showCreatePatientForm(Model model) {
        model.addAttribute("patient", new Patient());
        return "create-patient";
    }

    @PostMapping("/patients/new")
    public String createPatient(Patient patient) {
        patientService.savePatient(patient);
        return "redirect:/patients";
    }

    @GetMapping("/patients/{id}/edit")
    public String showEditPatientForm(@PathVariable Long id, Model model) {
        Patient patient = patientService.getPatientById(id);
        model.addAttribute("patient", patient);
        return "edit-patient";
    }

    @PostMapping("/patients/{id}/edit")
    public String updatePatient(@PathVariable Long id, Patient patient) {
        patientService.savePatient(patient);
        return "redirect:/patients";
    }

    @GetMapping("/patients/{id}/delete")
    public String deletePatient(@PathVariable Long id) {
        patientService.deletePatient(id);
        return "redirect:/patients";
    }
    @GetMapping("/doctors")
    public String showDoctorList(Model model) {
        model.addAttribute("doctors", doctorService.getAllDoctors());
        return "doctor-list";
    }

    @GetMapping("/doctors/new")
    public String showCreateDoctorForm(Model model) {
        model.addAttribute("doctor", new Doctor());
        return "create-doctor";
    }

    @PostMapping("/doctors/new")
    public String createDoctor(@ModelAttribute("doctor") Doctor doctor) {
        doctorService.saveDoctor(doctor);
        return "redirect:/doctors";
    }

    @GetMapping("/doctors/{id}/edit")
    public String showEditDoctorForm(@PathVariable Long id, Model model) {
        Doctor doctor = doctorService.getDoctorById(id);
        model.addAttribute("doctor", doctor);
        return "edit-doctor";
    }

    @PostMapping("/doctors/{id}/edit")
    public String updateDoctor(@PathVariable Long id, @ModelAttribute("doctor") Doctor doctor) {
        doctor.setId(id);
        doctorService.saveDoctor(doctor);
        return "redirect:/doctors";
    }

    @GetMapping("/doctors/{id}/delete")
    public String deleteDoctor(@PathVariable Long id) {
        doctorService.deleteDoctor(id);
        return "redirect:/doctors";
    }
}
