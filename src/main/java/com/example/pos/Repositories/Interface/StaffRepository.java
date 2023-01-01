package com.example.pos.Repositories.Interface;

import com.example.pos.Models.Staff;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface StaffRepository extends JpaRepository<Staff, Long> {

    @Query("SELECT s FROM Staff s WHERE s.staffId =:staffId")
    Optional<Staff> findById(Long staffId);

    @Modifying
    @Query("update Staff s set s.role = :role where s.staffId = :staffId")
    void updateStaffRole(@Param("role") String role, @Param("staffId") Long staffId);
}