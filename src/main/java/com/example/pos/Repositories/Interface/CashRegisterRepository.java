package com.example.pos.Repositories.Interface;

import com.example.pos.Models.CashRegister;
import com.example.pos.Models.Item;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface CashRegisterRepository extends JpaRepository<CashRegister, Long> {
    @Query("SELECT s FROM CashRegister s WHERE s.businessId =:businessId")
    List<CashRegister> findByBusinessId(Long businessId);
}
