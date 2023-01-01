package com.example.pos.Controllers;

import com.example.pos.Exceptions.ItemNotFoundException;
import com.example.pos.Models.CashRegister;
import com.example.pos.Models.Item;
import com.example.pos.Repositories.Interface.CashRegisterRepository;
import com.example.pos.Services.CashRegisterService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CashRegisterController {
    private final CashRegisterRepository cashRegisterRepository;
    private final CashRegisterService cashRegisterService;

    CashRegisterController(CashRegisterRepository cashRegisterRepository, CashRegisterService cashRegisterService) {
        this.cashRegisterRepository = cashRegisterRepository;
        this.cashRegisterService = cashRegisterService;
    }

    @GetMapping("/cashregisters")
    List<CashRegister> getAllRegisters() {
        return cashRegisterRepository.findAll();
    }

    @GetMapping("/cashregister/{registerId}")
    CashRegister findRegisterById(@PathVariable Long registerId) {

        return cashRegisterRepository.findById(registerId)
                .orElseThrow(() -> new ItemNotFoundException(registerId));
    }
    @GetMapping("/cashregister/business/{businessId}")
    List<CashRegister> findRegistersByBusinessId(@PathVariable Long businessId) {

        return cashRegisterService.findByBusinessId(businessId);
    }
    @PostMapping("/cashregister")
    CashRegister createNewItem(@RequestBody CashRegister newCashRegister) {

        return cashRegisterService.saveCashRegister(newCashRegister);
    }
    @DeleteMapping("/cashregister/{registerId}")
    void deleteItem(@PathVariable Long registerId) {
        cashRegisterService.deleteRegisterById(registerId);
    }
}
