package com.vk.healthhut.service;

import com.vk.healthhut.entity.Bookings;
import com.vk.healthhut.repository.BookingsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookingsService {

    private final BookingsRepository bookingRepository;

    @Autowired
    public BookingsService(BookingsRepository bookingRepository) {
        this.bookingRepository = bookingRepository;
    }

    // Create a new booking
    public Bookings createBooking(Bookings booking) {
        booking.setStatus("Pending"); // Set default status to Pending
        return bookingRepository.save(booking);
    }

    // Get all bookings for a patient
    public List<Bookings> getBookingsByPatientId(int patientId) {
        return bookingRepository.findByPatientId(patientId);
    }

    // Get all bookings for a doctor
    public List<Bookings> getBookingsByDoctorId(int doctorId) {
        return bookingRepository.findByDoctorId(doctorId);
    }

    // Update booking status
    public Bookings updateBookingStatus(int bookingId, String status) {
        Bookings booking = bookingRepository.findById(bookingId).orElseThrow();
        booking.setStatus(status);
        return bookingRepository.save(booking);
    }

    // Get all bookings
    public List<Bookings> getAllBookings() {
        return bookingRepository.findAll();
    }
}
