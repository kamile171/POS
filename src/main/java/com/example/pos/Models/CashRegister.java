package com.example.pos.Models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

import java.math.BigDecimal;

@Entity
public class CashRegister {
    @Id
    @GeneratedValue
    private Long registerId;
    private Long businessId;
    //private Boolean isLoggedIn;????
    private Long currentCashierId;
    private BigDecimal totalEarnings;
    private int transactionCount;
    private BigDecimal cashInRegister;
    private String preferredCurrency;

    public CashRegister(Long businessId, Long currentCashierId, BigDecimal totalEarnings, int transactionCount, BigDecimal cashInRegister, String preferredCurrency) {
        this.businessId = businessId;
        this.currentCashierId = currentCashierId;
        this.totalEarnings = totalEarnings;
        this.transactionCount = transactionCount;
        this.cashInRegister = cashInRegister;
        this.preferredCurrency = preferredCurrency;
    }

    public CashRegister() {

    }

    public Long getRegisterId() {
        return registerId;
    }

    public void setRegisterId(Long registerId) {
        this.registerId = registerId;
    }

    public Long getBusinessId() {
        return businessId;
    }

    public void setBusinessId(Long businessId) {
        this.businessId = businessId;
    }

    public Long getCurrentCashierId() {
        return currentCashierId;
    }

    public void setCurrentCashierId(Long currentCashierId) {
        this.currentCashierId = currentCashierId;
    }

    public BigDecimal getTotalEarnings() {
        return totalEarnings;
    }

    public void setTotalEarnings(BigDecimal totalEarnings) {
        this.totalEarnings = totalEarnings;
    }

    public int getTransactionCount() {
        return transactionCount;
    }

    public void setTransactionCount(int transactionCount) {
        this.transactionCount = transactionCount;
    }

    public BigDecimal getCashInRegister() {
        return cashInRegister;
    }

    public void setCashInRegister(BigDecimal cashInRegister) {
        this.cashInRegister = cashInRegister;
    }

    public String getPreferredCurrency() {
        return preferredCurrency;
    }

    public void setPreferredCurrency(String preferredCurrency) {
        this.preferredCurrency = preferredCurrency;
    }
}
