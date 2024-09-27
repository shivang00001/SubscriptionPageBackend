package com.assignment.sub_assignment.repository;

import com.assignment.sub_assignment.entity.Subscription;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SubscriptionRepository extends JpaRepository<Subscription, Long> {
}
