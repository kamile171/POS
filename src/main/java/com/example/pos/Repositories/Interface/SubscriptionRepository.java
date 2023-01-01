package com.example.pos.Repositories.Interface;

import com.example.pos.Models.Subscription;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SubscriptionRepository extends JpaRepository<Subscription, Long> {
}
