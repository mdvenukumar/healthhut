package com.vk.healthhut.repository;

import com.vk.healthhut.entity.Doctor;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DoctorRepository extends JpaRepository<Doctor, Integer> {
    Doctor findByEmailAndPassword(String email, String password);
}
