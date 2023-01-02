package com.example.pos.Models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

@Entity
public class Fault {
    @Id
    @GeneratedValue
    private Long faultId;
    private String urgency;
    private String description;
    private Long staffId;

    public Fault(String urgency, String description, Long staffId) {
        this.urgency = urgency;
        this.description = description;
        this.staffId = staffId;
    }

    public Fault() {

    }

    public Long getFaultId() {
        return faultId;
    }

    public void setFaultId(Long faultId) {
        this.faultId = faultId;
    }

    public String getUrgency() {
        return urgency;
    }

    public void setUrgency(String urgency) {
        this.urgency = urgency;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Long getStaffId() {
        return staffId;
    }

    public void setStaffId(Long staffId) {
        this.staffId = staffId;
    }
}