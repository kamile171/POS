package com.example.pos.Controllers;

import com.example.pos.Exceptions.ItemNotFoundException;
import com.example.pos.Models.Subscription;
import com.example.pos.Repositories.Interface.SubscriptionRepository;
import com.example.pos.Services.SubscriptionService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class SubscriptionController {
    private final SubscriptionRepository subscriptionRepository;
    private final SubscriptionService subscriptionService;

    SubscriptionController(SubscriptionRepository subscriptionRepository, SubscriptionService subscriptionService ) {
        this.subscriptionRepository = subscriptionRepository;
        this.subscriptionService = subscriptionService;
    }
    @GetMapping("/subscriptions")
    List<Subscription> getAllSubscriptions() {
        return subscriptionRepository.findAll();
    }
    @GetMapping("/subscription/{id}")
    Subscription findSubscriptionById(@PathVariable Long id) {

        return subscriptionRepository.findById(id)
                .orElseThrow(() -> new ItemNotFoundException(id));
    }
    @PostMapping("/subscription")
    Subscription createNewSubscription(@RequestBody Subscription newSubscription) {

        return subscriptionService.saveSubscription(newSubscription);
    }
    @PutMapping("/subscription")
    Subscription updateSubscription(@RequestBody Subscription newSubscription) {
        return subscriptionService.updateSubscription(newSubscription);
    }
    @DeleteMapping("/subscription/{id}")
    void deleteItem(@PathVariable Long id) {
        subscriptionService.deleteSubscriptionById(id);
    }
}
