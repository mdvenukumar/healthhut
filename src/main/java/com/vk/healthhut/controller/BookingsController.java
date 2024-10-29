package com.vk.healthhut.controller;

import com.vk.healthhut.entity.Bookings;
import com.vk.healthhut.service.BookingsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/bookings")
@CrossOrigin("https://localhost:5173")
public class BookingsController {

    private final BookingsService bookingsService;

    @Autowired
    public BookingsController(BookingsService bookingsService) {
        this.bookingsService = bookingsService;
    }

    // Create a new booking
    @PostMapping("/add")
    public ResponseEntity<Bookings> createBooking(@RequestBody Bookings booking) {
        return ResponseEntity.ok(bookingsService.createBooking(booking));
    }

    // Update booking status
    @PutMapping("/{bookingId}/status")
    public ResponseEntity<Bookings> updateBookingStatus(@PathVariable int bookingId, @RequestParam String status) {
        return ResponseEntity.ok(bookingsService.updateBookingStatus(bookingId, status));
    }

    // Get all bookings for a patient
    @GetMapping("/patient/{patientId}")
    public ResponseEntity<List<Bookings>> getBookingsByPatientId(@PathVariable int patientId) {
        return ResponseEntity.ok(bookingsService.getBookingsByPatientId(patientId));
    }

    // Get all bookings for a doctor
    @GetMapping("/doctor/{doctorId}")
    public ResponseEntity<List<Bookings>> getBookingsByDoctorId(@PathVariable int doctorId) {
        return ResponseEntity.ok(bookingsService.getBookingsByDoctorId(doctorId));
    }

    // Get all bookings
    @GetMapping
    public ResponseEntity<List<Bookings>> getAllBookings() {
        return ResponseEntity.ok(bookingsService.getAllBookings());
    }
}
