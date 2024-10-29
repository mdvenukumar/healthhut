package com.vk.healthhut.repository;

import com.vk.healthhut.entity.Patient;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface PatientRepository extends JpaRepository<Patient, Integer> {
    Optional<Patient> findByEmailAndPassword(String email, String password);
}
