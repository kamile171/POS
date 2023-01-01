package com.example.pos.Services;

import com.example.pos.Exceptions.InvalidInputException;
import com.example.pos.Exceptions.ItemNotFoundException;
import com.example.pos.Models.CashRegister;
import com.example.pos.Repositories.Interface.CashRegisterRepository;
import com.example.pos.Repositories.Interface.SubscriptionRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CashRegisterService {
    private final CashRegisterRepository cashRegisterRepository;
    private final SubscriptionRepository subscriptionRepository;

    CashRegisterService(CashRegisterRepository cashRegisterRepository, SubscriptionRepository subscriptionRepository) {
        this.cashRegisterRepository = cashRegisterRepository;
        this.subscriptionRepository = subscriptionRepository;
    }
    public List<CashRegister> findByBusinessId(Long id) {
        List<CashRegister> registersById = new ArrayList<>();

        if (!subscriptionRepository.existsById(id)) {
            throw new ItemNotFoundException(id);
        }

        registersById.addAll(cashRegisterRepository.findByBusinessId(id));

        return registersById;
    }
    public CashRegister saveCashRegister(CashRegister newCashRegister) {

        //check if business exists
        if (!subscriptionRepository.existsById(newCashRegister.getBusinessId())) {
            throw new ItemNotFoundException(newCashRegister.getBusinessId());
        }

        //check if cashier exists
        //******************************
        //

        if (newCashRegister.getTotalEarnings() == null || newCashRegister.getCashInRegister() == null || newCashRegister.getPreferredCurrency() == null) {
            throw new InvalidInputException();
        }

        return cashRegisterRepository.save(newCashRegister);
    }
    public void deleteRegisterById(Long id) {

        if (!cashRegisterRepository.existsById(id)) {
            throw new ItemNotFoundException(id);
        }
        cashRegisterRepository.deleteById(id);
    }
}
