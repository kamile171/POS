package com.example.pos.Models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

import java.math.BigDecimal;

@Entity
public class Subscription {
    @Id
    @GeneratedValue
    private Long businessId;
    private String businessName;
    private int daysUntilNextPayment;
    private BigDecimal paymentAmount;

    public Subscription(String businessName, int daysUntilNextPayment, BigDecimal paymentAmount) {
        this.businessName = businessName;
        this.daysUntilNextPayment = daysUntilNextPayment;
        this.paymentAmount = paymentAmount;
    }

    public Subscription() {

    }

    public Long getBusinessId() {
        return businessId;
    }

    public void setBusinessId(Long businessId) {
        this.businessId = businessId;
    }

    public String getBusinessName() {
        return businessName;
    }

    public void setBusinessName(String businessName) {
        this.businessName = businessName;
    }

    public int getDaysUntilNextPayment() {
        return daysUntilNextPayment;
    }

    public void setDaysUntilNextPayment(int daysUntilNextPayment) {
        this.daysUntilNextPayment = daysUntilNextPayment;
    }

    public BigDecimal getPaymentAmount() {
        return paymentAmount;
    }

    public void setPaymentAmount(BigDecimal paymentAmount) {
        this.paymentAmount = paymentAmount;
    }
}
