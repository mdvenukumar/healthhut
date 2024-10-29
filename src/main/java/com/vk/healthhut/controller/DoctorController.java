package com.vk.healthhut.controller;

import com.vk.healthhut.entity.Doctor;
import com.vk.healthhut.entity.Bookings;
import com.vk.healthhut.service.DoctorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/doctors")
@CrossOrigin("http://localhost:5173/")
public class DoctorController {

    private final DoctorService doctorService;

    @Autowired
    public DoctorController(DoctorService doctorService) {
        this.doctorService = doctorService;
    }

    // Register a new doctor
    @PostMapping("/register")
    public ResponseEntity<Map<String, Object>> registerDoctor(@RequestBody Doctor doctor) {
        Doctor registeredDoctor = doctorService.registerDoctor(doctor);
        Map<String, Object> response = new HashMap<>();
        response.put("message", "Doctor registered successfully");
        response.put("doctor", registeredDoctor);
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }

    // Login doctor by email and password
    @PostMapping("/login")
    public ResponseEntity<Map<String, Object>> loginDoctor(@RequestParam String email, @RequestParam String password) {
        Doctor doctor = doctorService.findByEmailAndPassword(email, password);
        Map<String, Object> response = new HashMap<>();

        if (doctor != null) {
            response.put("message", "Login successful");
            response.put("doctor", doctor);
            return new ResponseEntity<>(response, HttpStatus.OK);
        } else {
            response.put("message", "Invalid email or password");
            return new ResponseEntity<>(response, HttpStatus.UNAUTHORIZED);
        }
    }

    // Update doctor's information
    @PutMapping("/{doctorId}")
    public ResponseEntity<Map<String, Object>> updateDoctor(@PathVariable int doctorId, @RequestBody Doctor doctor) {
        doctor.setId(doctorId);
        Doctor updatedDoctor = doctorService.updateDoctor(doctor);
        Map<String, Object> response = new HashMap<>();

        if (updatedDoctor != null) {
            response.put("message", "Doctor updated successfully");
            response.put("doctor", updatedDoctor);
            return new ResponseEntity<>(response, HttpStatus.OK);
        } else {
            response.put("message", "Doctor not found");
            return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
        }
    }

    // Get all bookings for a doctor
    @GetMapping("/{doctorId}/bookings")
    public ResponseEntity<Map<String, Object>> getDoctorBookings(@PathVariable int doctorId) {
        List<Bookings> bookings = doctorService.getDoctorBookings(doctorId);
        Map<String, Object> response = new HashMap<>();

        if (!bookings.isEmpty()) {
            response.put("message", "Bookings retrieved successfully");
            response.put("bookings", bookings);
            return new ResponseEntity<>(response, HttpStatus.OK);
        } else {
            response.put("message", "No bookings found for this doctor");
            return new ResponseEntity<>(response, HttpStatus.NO_CONTENT);
        }
    }

    // Get all doctors
    @GetMapping
    public ResponseEntity<Map<String, Object>> getAllDoctors() {
        List<Doctor> doctors = doctorService.getAllDoctors();
        Map<String, Object> response = new HashMap<>();

        response.put("message", "Doctors retrieved successfully");
        response.put("doctors", doctors);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }
}
