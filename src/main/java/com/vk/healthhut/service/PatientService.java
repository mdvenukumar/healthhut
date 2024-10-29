package com.vk.healthhut.service;


import com.vk.healthhut.entity.Doctor;
import com.vk.healthhut.entity.MedicalHistory;
import com.vk.healthhut.entity.Patient;
import com.vk.healthhut.entity.Bookings;
import com.vk.healthhut.repository.PatientRepository;
import com.vk.healthhut.repository.DoctorRepository;
import com.vk.healthhut.repository.BookingsRepository;
import com.vk.healthhut.repository.MedicalHistoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PatientService {

    private final PatientRepository patientRepository;
    private final DoctorRepository doctorRepository;
    private final BookingsRepository bookingRepository;
    private final MedicalHistoryRepository medicalHistoryRepository;

    @Autowired
    public PatientService(PatientRepository patientRepository,
                          DoctorRepository doctorRepository,
                          BookingsRepository bookingRepository, BookingsRepository bookingRepository1,
                          MedicalHistoryRepository medicalHistoryRepository) {
        this.patientRepository = patientRepository;
        this.doctorRepository = doctorRepository;
        this.bookingRepository = bookingRepository;
        this.medicalHistoryRepository = medicalHistoryRepository;
    }

    // Register a new patient
    public Patient registerPatient(Patient patient) {
        // Hash password here if necessary
        return patientRepository.save(patient);
    }

    // Get patient by email and password
    public Optional<Patient> findByEmailAndPassword(String email, String password) {
        return patientRepository.findByEmailAndPassword(email, password);
    }

    // Get all available doctors
    public List<Doctor> getAllDoctors() {
        return doctorRepository.findAll();
    }

    // Create a new booking with the selected doctor
    public Bookings createBooking(Bookings booking) {
        booking.setStatus("pending"); // Default status
        return bookingRepository.save(booking);
    }

    // Get all bookings for a patient
    public List<Bookings> getPatientBookings(int patientId) {
        return bookingRepository.findByPatientId(patientId);
    }

    // Get all bookings for a doctor
    public List<Bookings> getDoctorBookings(int doctorId) {
        return bookingRepository.findByDoctorId(doctorId);
    }

    // Add new medical history entry for a patient
    public MedicalHistory addMedicalHistory(MedicalHistory medicalHistory) {
        return medicalHistoryRepository.save(medicalHistory);
    }

    // Get medical history entries for a patient
    public List<MedicalHistory> getPatientMedicalHistory(int patientId) {
        return medicalHistoryRepository.findByPatientId(patientId);
    }
}
