package com.vk.healthhut.entity;

import jakarta.persistence.*;

@Entity
@Table
public class Patient {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "patient_id")
    private int patientId;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private int age;

    @Column(nullable = false)
    private String sex;

    private int height;
    private int weight;

    private String address;

    private String phone;

    @Column(nullable = false, unique = true)
    private String email;

    @Column(nullable = false)
    private String password;

    private String medical_history;

    //empty constructor
    public Patient(){}

    //constructor
    public Patient(int patient_id, String name, int age, String sex, int height, int weight, String address, String phone, String email, String password, String medical_history) {
        this.patientId = patient_id;
        this.name = name;
        this.age = age;
        this.sex = sex;
        this.height = height;
        this.weight = weight;
        this.address = address;
        this.phone = phone;
        this.email = email;
        this.password = password;
        this.medical_history = medical_history;
    }

    public int getPatient_id() {
        return patientId;
    }
    public void setPatient_id(int patient_id) {
        this.patientId = patient_id;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public int getAge() {
        return age;
    }
    public void setAge(int age) {
        this.age = age;
    }
    public String getSex() {
        return sex;
    }
    public void setSex(String sex){
        this.sex = sex;
    }
    public int getHeight() {
        return height;
    }
    public void setHeight(int height) {
        this.height = height;
    }
    public int getWeight() {
        return weight;
    }
    public void setWeight(int weight) {
        this.weight = weight;
    }
    public String getAddress() {
        return address;
    }
    public void setAddress(String address) {
        this.address = address;
    }
    public String getPhone() {
        return phone;
    }
    public void setPhone(String phone) {
        this.phone = phone;
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }
    public String getMedical_history() {
        return medical_history;
    }
    public void setMedical_history(String medical_history) {
        this.medical_history = medical_history;
    }
}