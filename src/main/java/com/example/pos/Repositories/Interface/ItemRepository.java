package com.example.pos.Repositories.Interface;

import com.example.pos.Models.Item;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.math.BigDecimal;
import java.util.List;

public interface ItemRepository extends JpaRepository<Item, Long> {

    @Query("SELECT s FROM Item s WHERE s.itemName =:itemName")
    List<Item> findByItemName(String itemName);
    @Query("SELECT s FROM Item s WHERE s.cost =:cost")
    List<Item> findByCost(BigDecimal cost);
    @Query("SELECT s FROM Item s WHERE s.discountPercentage =:discountPercentage")
    List<Item> findByDiscountPercentage(Double discountPercentage);

}
