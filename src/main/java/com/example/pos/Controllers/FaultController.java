package com.example.pos.Controllers;

import com.example.pos.Exceptions.FaultNotFoundException;
import com.example.pos.Models.Fault;
import com.example.pos.Repositories.Interface.FaultRepository;
import com.example.pos.Services.FaultService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class FaultController {

    private final FaultRepository faultRepository;
    private final FaultService faultService;

    FaultController(FaultRepository faultRepository, FaultService faultService) {
        this.faultRepository = faultRepository;
        this.faultService = faultService;
    }

    @GetMapping("/faults")
    List<Fault> getAllFault() {
        return faultRepository.findAll();
    }

    @PutMapping("/fault/{faultId}")
    Fault updateFault(@RequestBody Fault newFault, @PathVariable Long faultId) {
        return faultService.updateFault(newFault, faultId);
    }

    @PostMapping("/fault")
    Fault createNewFault(@RequestBody Fault newFault) {
        return faultService.saveFault(newFault);
    }

    @GetMapping("/fault/{faultId}")
    Fault findFaultById(@PathVariable Long faultId) {

        return faultRepository.findById(faultId)
               .orElseThrow(() -> new FaultNotFoundException(faultId));
    }

    @DeleteMapping("/fault/{faultId}")
    void deleteFault(@PathVariable Long faultId) {
        faultService.deleteFaultById(faultId);
    }
}