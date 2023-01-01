package com.example.pos.Models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

import java.lang.reflect.Array;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
public class Order {

    private @Id @GeneratedValue Long id;
    private Long registerId;
    private Long itemId;
    private Number totalValue;
    private LocalDateTime dateTime;
    private String paymentMethod;
    private Boolean isInactive;
    private Number loyalty;
    private String orderComment;
    private Long[] items;


    public Order(Long registerId, Long itemId, Number totalValue, LocalDateTime dateTime, String paymentMethod, Boolean isInactive, Number loyalty, String orderComment, Long[] items) {
        this.registerId = registerId;
        this.itemId = itemId;
        this.totalValue = totalValue;
        this.dateTime = dateTime;
        this.paymentMethod = paymentMethod;
        this.isInactive = isInactive;
        this.loyalty = loyalty;
        this.orderComment = orderComment;
        this.items = items;
    }

    public Order() {

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getRegisterId() {
        return registerId;
    }

    public void setRegisterId(Long registerId) {
        this.registerId = registerId;
    }

    public Long getItemId() {
        return itemId;
    }

    public void setItemId(Long itemId) {
        this.itemId = itemId;
    }

    public Number getTotalValue() {
        return totalValue;
    }

    public void setTotalValue(Number totalValue) {
        this.totalValue = totalValue;
    }

    public LocalDateTime getDateTime() {
        return dateTime;
    }

    public void setDateTime(LocalDateTime dateTime) {
        this.dateTime = dateTime;
    }

    public String getPaymentMethod() {
        return paymentMethod;
    }

    public void setPaymentMethod(String paymentMethod) {
        this.paymentMethod = paymentMethod;
    }

    public Boolean getIsInactive() {
        return isInactive;
    }

    public void setIsInactive(Boolean isInactive) {
        this.isInactive = isInactive;
    }

    public Number getLoyalty() {
        return loyalty;
    }

    public void setLoyalty(Number loyalty) {
        this.loyalty = loyalty;
    }

    public String getOrderComment() {
        return orderComment;
    }

    public void setOrderComment(String orderComment) {
        this.orderComment = orderComment;
    }

    public Long[] getItems() {return items;}

    public void setItems(Long[] items) {this.items = items;}

}
