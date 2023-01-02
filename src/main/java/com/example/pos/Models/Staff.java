package com.example.pos.Models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

import java.time.LocalDateTime;

@Entity
public class Staff {
    @Id
    @GeneratedValue
    private Long staffId;
    private String name;
    private String surname;
    private LocalDateTime dateOfEntrance;
    private Double totalHoursWorked;
    private String role;


    public Staff(String name, String surname, LocalDateTime dateOfEntrance, Double totalHoursWorked, String role) {
        this.name = name;
        this.surname = surname;
        this.dateOfEntrance = dateOfEntrance;
        this.totalHoursWorked = totalHoursWorked;
        this.role = role;
    }

    public Staff() {

    }

    public Long getStaffId() {
        return staffId;
    }

    public void setStaffId(Long staffId) {
        this.staffId = staffId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public LocalDateTime getDateOfEntrance() {
        return dateOfEntrance;
    }

    public void setDateOfEntrance(LocalDateTime dateOfEntrance) {
        this.dateOfEntrance = dateOfEntrance;
    }

    public Double getTotalHoursWorked() {
        return totalHoursWorked;
    }

    public void setTotalHoursWorked(Double totalHoursWorked) {
        this.totalHoursWorked = totalHoursWorked;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }
}
