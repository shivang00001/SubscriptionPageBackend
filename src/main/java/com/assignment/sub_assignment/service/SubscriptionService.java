package com.assignment.sub_assignment.service;

import com.assignment.sub_assignment.dto.SubscriptionDTO;
import com.assignment.sub_assignment.entity.Package;
import com.assignment.sub_assignment.entity.Subscription;
import com.assignment.sub_assignment.repository.SubscriptionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SubscriptionService {

    @Autowired
    private SubscriptionRepository subscriptionRepository;

    public Subscription createSubscription(SubscriptionDTO subscriptionDTO) {
        Subscription subscription = new Subscription();
        subscription.setName(subscriptionDTO.getName());
        subscription.setCost(subscriptionDTO.getCost());
        subscription.setDescription(subscriptionDTO.getDescription());
        return subscriptionRepository.save(subscription);
    }

    public List<Subscription> getAllSubscription() {
        return subscriptionRepository.findAll();
    }
}
