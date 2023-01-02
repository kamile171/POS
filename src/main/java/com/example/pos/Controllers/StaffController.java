package com.example.pos.Controllers;

import com.example.pos.Exceptions.StaffNotFoundException;
import com.example.pos.Models.Staff;
import com.example.pos.Repositories.Interface.StaffRepository;
import com.example.pos.Services.StaffService;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

@RestController
public class StaffController {

    private final StaffRepository staffRepository;
    private final StaffService staffService;

    StaffController(StaffRepository staffRepository, StaffService staffService) {
        this.staffRepository = staffRepository;
        this.staffService = staffService;
    }

    @GetMapping("/staff")
    List<Staff> getAllStaff() {
        return staffRepository.findAll();
    }

    @PutMapping("/staff")
    Staff updateStaff(@RequestBody Staff newStaff) {
        return staffService.updateStaff(newStaff);
    }

    @PostMapping("/staff")
    Staff createNewStaff(@RequestBody Staff newStaff) {
        return staffService.saveStaff(newStaff);
    }

    @GetMapping("/staff/{staffId}")
    Staff findStaffById(@PathVariable Long staffId) {

        return staffRepository.findById(staffId)
               .orElseThrow(() -> new StaffNotFoundException(staffId));
    }

    @DeleteMapping("/staff/{staffId}")
    void deleteStaff(@PathVariable Long staffId) {
        staffService.deleteStaffById(staffId);
    }

    @PutMapping("/staff/{staffId}/role")
    void updateStaffRole(@PathVariable String role, @PathVariable Long staffId) {
        staffRepository.updateStaffRole(role, staffId);
    }
}