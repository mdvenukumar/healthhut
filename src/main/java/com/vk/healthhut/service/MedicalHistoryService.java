package com.vk.healthhut.service;

import com.vk.healthhut.entity.MedicalHistory;
import com.vk.healthhut.repository.MedicalHistoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MedicalHistoryService {

    private final MedicalHistoryRepository medicalHistoryRepository;

    @Autowired
    public MedicalHistoryService(MedicalHistoryRepository medicalHistoryRepository) {
        this.medicalHistoryRepository = medicalHistoryRepository;
    }

    // Add new medical history entry
    public MedicalHistory addMedicalHistory(MedicalHistory medicalHistory) {
        return medicalHistoryRepository.save(medicalHistory);
    }

    // Get all medical history for a patient
    public List<MedicalHistory> getMedicalHistoryByPatientId(int patientId) {
        return medicalHistoryRepository.findByPatientId(patientId);
    }

    // Get all medical history entries
    public List<MedicalHistory> getAllMedicalHistory() {
        return medicalHistoryRepository.findAll();
    }
}
