package com.example.pos.Services;

import com.example.pos.Exceptions.InvalidInputException;
import com.example.pos.Exceptions.ItemNotFoundException;
import com.example.pos.Models.Subscription;
import com.example.pos.Repositories.Interface.SubscriptionRepository;
import org.springframework.stereotype.Service;

@Service
public class SubscriptionService {
    private final SubscriptionRepository subscriptionRepository;

    SubscriptionService(SubscriptionRepository subscriptionRepository) {
        this.subscriptionRepository = subscriptionRepository;
    }

    public Subscription saveSubscription(Subscription newSubscription) {

        if (newSubscription.getBusinessName() == null || newSubscription.getPaymentAmount() == null) {
            throw new InvalidInputException();
        }
        return subscriptionRepository.save(newSubscription);
    }
    public Subscription updateSubscription(Subscription newSubscription) {

        return subscriptionRepository.findById(newSubscription.getBusinessId())
                .map(subscription -> {
                    subscription.setBusinessName(newSubscription.getBusinessName());
                    subscription.setDaysUntilNextPayment(newSubscription.getDaysUntilNextPayment());
                    subscription.setPaymentAmount(newSubscription.getPaymentAmount());
                    return subscriptionRepository.save(subscription);
                })
                .orElseThrow(() -> new ItemNotFoundException(newSubscription.getBusinessId()));
    }
    public void deleteSubscriptionById(Long id) {

        if (!subscriptionRepository.existsById(id)) {
            throw new ItemNotFoundException(id);
        }
        subscriptionRepository.deleteById(id);
    }
}
