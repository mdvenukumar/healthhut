package com.vk.healthhut.repository;

import com.vk.healthhut.entity.Bookings;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BookingsRepository extends JpaRepository<Bookings, Integer> {
    List<Bookings> findByPatientId(int patientId);

    List<Bookings> findByDoctorId(int doctorId);
}
