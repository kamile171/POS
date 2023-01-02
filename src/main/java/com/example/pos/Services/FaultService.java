package com.example.pos.Services;

import com.example.pos.Exceptions.InvalidInputException;
import com.example.pos.Exceptions.FaultNotFoundException;
import com.example.pos.Models.Fault;
import com.example.pos.Repositories.Interface.FaultRepository;
import org.springframework.stereotype.Service;

@Service
public class FaultService {

    private final FaultRepository faultRepository;

    FaultService(FaultRepository faultRepository) {
        this.faultRepository = faultRepository;
    }

    public void deleteFaultById(Long faultId) {

        if (!faultRepository.existsById(faultId)) {
            throw new FaultNotFoundException(faultId);
        }
        faultRepository.deleteById(faultId);
    }

    public Fault saveFault(Fault newFault) {

        if (newFault.getUrgency() == null || newFault.getDescription() == null || newFault.getStaffId() == null) {
            throw new InvalidInputException();
        }
        return faultRepository.save(newFault);
    }

    public Fault updateFault(Fault newFault, Long faultId) {

        return faultRepository.findById(faultId)
                .map(fault -> {
                    fault.setUrgency(newFault.getUrgency());
                    fault.setDescription(newFault.getDescription());
                    fault.setStaffId(newFault.getStaffId());
                    return faultRepository.save(fault);
                })
                .orElseThrow(() -> new FaultNotFoundException(newFault.getFaultId()));
    }
}