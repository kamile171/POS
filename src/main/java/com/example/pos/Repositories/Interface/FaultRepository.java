package com.example.pos.Repositories.Interface;

import com.example.pos.Models.Fault;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface FaultRepository extends JpaRepository<Fault, Long> {

    @Query("SELECT s FROM Fault s WHERE s.faultId =:faultId")
    Optional<Fault> findById(Long faultId);

}