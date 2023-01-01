package com.example.pos.Models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

import java.math.BigDecimal;
@Entity
public class Item {
    @Id @GeneratedValue
    private Long id;
    private String itemName;
    private BigDecimal cost;
    private Double discountPercentage;

    public Item(){}

    public Item(String itemName, BigDecimal cost, Double discountPercentage) {
        this.itemName = itemName;
        this.cost = cost;
        this.discountPercentage = discountPercentage;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public BigDecimal getCost() {
        return cost;
    }

    public void setCost(BigDecimal cost) {
        this.cost = cost;
    }

    public Double getDiscountPercentage() {
        return discountPercentage;
    }

    public void setDiscountPercentage(Double discountPercentage) {
        this.discountPercentage = discountPercentage;
    }
}
