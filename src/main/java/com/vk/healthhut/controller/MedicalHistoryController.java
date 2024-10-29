package com.vk.healthhut.controller;

import com.vk.healthhut.entity.MedicalHistory;
import com.vk.healthhut.service.MedicalHistoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/medical-history")
@CrossOrigin("http://localhost:5173/")
public class MedicalHistoryController {

    private final MedicalHistoryService medicalHistoryService;

    @Autowired
    public MedicalHistoryController(MedicalHistoryService medicalHistoryService) {
        this.medicalHistoryService = medicalHistoryService;
    }

    // Add new medical history entry
    @PostMapping
    public ResponseEntity<MedicalHistory> addMedicalHistory(@RequestBody MedicalHistory medicalHistory) {
        return ResponseEntity.ok(medicalHistoryService.addMedicalHistory(medicalHistory));
    }

    // Get all medical history entries for a patient
    @GetMapping("/patient/{patientId}")
    public ResponseEntity<List<MedicalHistory>> getMedicalHistoryByPatientId(@PathVariable int patientId) {
        return ResponseEntity.ok(medicalHistoryService.getMedicalHistoryByPatientId(patientId));
    }

    // Get all medical history entries
    @GetMapping
    public ResponseEntity<List<MedicalHistory>> getAllMedicalHistory() {
        return ResponseEntity.ok(medicalHistoryService.getAllMedicalHistory());
    }
}
