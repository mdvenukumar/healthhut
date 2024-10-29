package com.vk.healthhut.service;


import com.vk.healthhut.entity.Doctor;
import com.vk.healthhut.entity.Bookings;
import com.vk.healthhut.repository.DoctorRepository;
import com.vk.healthhut.repository.BookingsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DoctorService {

    private final DoctorRepository doctorRepository;
    private final BookingsRepository bookingRepository;

    @Autowired
    public DoctorService(DoctorRepository doctorRepository,
                         BookingsRepository bookingRepository) {
        this.doctorRepository = doctorRepository;
        this.bookingRepository = bookingRepository;
    }

    // Register a new doctor
    public Doctor registerDoctor(Doctor doctor) {
        // Hash password here if necessary
        return doctorRepository.save(doctor);
    }

    // Get doctor by email and password
    public Doctor findByEmailAndPassword(String email, String password) {
        return doctorRepository.findByEmailAndPassword(email, password);
    }

    // Get all bookings for a doctor
    public List<Bookings> getDoctorBookings(int doctorId) {
        return bookingRepository.findByDoctorId(doctorId);
    }

    // Update doctor's information
    public Doctor updateDoctor(Doctor doctor) {
        // You might want to validate doctor exists before updating
        return doctorRepository.save(doctor);
    }

    // Get all doctors
    public List<Doctor> getAllDoctors() {
        return doctorRepository.findAll();
    }
}
