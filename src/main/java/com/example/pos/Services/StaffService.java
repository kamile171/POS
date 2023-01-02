package com.example.pos.Services;

import com.example.pos.Exceptions.InvalidInputException;
import com.example.pos.Exceptions.StaffNotFoundException;
import com.example.pos.Models.Staff;
import com.example.pos.Repositories.Interface.StaffRepository;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Service
public class StaffService {

    private final StaffRepository staffRepository;

    StaffService(StaffRepository staffRepository) {
        this.staffRepository = staffRepository;
    }

    public void deleteStaffById(Long staffId) {

        if (!staffRepository.existsById(staffId)) {
            throw new StaffNotFoundException(staffId);
        }
        staffRepository.deleteById(staffId);
    }

    public Staff saveStaff(Staff newStaff) {

        if (newStaff.getStaffId() == null || newStaff.getName() == null || newStaff.getSurname() == null || newStaff.getDateOfEntrance() == null || newStaff.getTotalHoursWorked() == null || newStaff.getRole() == null) {
            throw new InvalidInputException();
        }
        return staffRepository.save(newStaff);
    }

    public Staff updateStaff(Staff newStaff) {

        return staffRepository.findById(newStaff.getStaffId())
                .map(staff -> {
                    staff.setName(newStaff.getName());
                    staff.setSurname(newStaff.getSurname());
                    staff.setDateOfEntrance(newStaff.getDateOfEntrance());
                    staff.setTotalHoursWorked(newStaff.getTotalHoursWorked());
                    staff.setRole(newStaff.getRole());
                    return staffRepository.save(staff);
                })
                .orElseThrow(() -> new StaffNotFoundException(newStaff.getStaffId()));
    }
}