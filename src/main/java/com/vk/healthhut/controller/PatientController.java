package com.vk.healthhut.controller;

import com.vk.healthhut.entity.Patient;
import com.vk.healthhut.entity.Doctor;
import com.vk.healthhut.entity.Bookings;
import com.vk.healthhut.entity.MedicalHistory;
import com.vk.healthhut.service.PatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/patients")
@CrossOrigin("http://localhost:5173/")
public class PatientController {

    private final PatientService patientService;

    @Autowired
    public PatientController(PatientService patientService) {
        this.patientService = patientService;
    }

    // Register a new patient
    @PostMapping("/register")
    public ResponseEntity<Patient> registerPatient(@RequestBody Patient patient) {
        return ResponseEntity.ok(patientService.registerPatient(patient));
    }

    // Login patient by email and password
    @PostMapping("/login")
    public ResponseEntity<Patient> loginPatient(@RequestParam String email, @RequestParam String password) {
        Optional<Patient> patient = patientService.findByEmailAndPassword(email, password);
        return patient.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.status(401).build());
    }


    // Get all available doctors
    @GetMapping("/doctors")
    public ResponseEntity<List<Doctor>> getAllDoctors() {
        return ResponseEntity.ok(patientService.getAllDoctors());
    }

    // Get all bookings for a patient
    @GetMapping("/{patientId}/bookings")
    public ResponseEntity<List<Bookings>> getPatientBookings(@PathVariable int patientId) {
        return ResponseEntity.ok(patientService.getPatientBookings(patientId));
    }

    // Get all medical history entries for a patient
    @GetMapping("/{patientId}/medical-history")
    public ResponseEntity<List<MedicalHistory>> getPatientMedicalHistory(@PathVariable int patientId) {
        return ResponseEntity.ok(patientService.getPatientMedicalHistory(patientId));
    }
}
