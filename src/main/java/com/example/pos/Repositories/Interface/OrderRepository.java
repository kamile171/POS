package com.example.pos.Repositories.Interface;

import com.example.pos.Models.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.math.BigDecimal;
import java.util.List;

public interface OrderRepository extends JpaRepository<Order, Long> {

    @Query("SELECT s FROM Order s WHERE s.isInactive =:isInactive")
    List<Order> findByOrderStatus(Boolean isInactive);

    @Query("SELECT s FROM Order s WHERE s.orderComment =:orderComment")
    List<Order> findByDescription(String orderComment);

    @Query("SELECT s FROM Order s WHERE s.items =:items")
    List<Order> findByitemId(Long[] items);
}