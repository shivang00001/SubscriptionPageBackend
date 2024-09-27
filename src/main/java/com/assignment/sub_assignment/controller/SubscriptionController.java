package com.assignment.sub_assignment.controller;

import com.assignment.sub_assignment.dto.SubscriptionDTO;
import com.assignment.sub_assignment.entity.Subscription;
import com.assignment.sub_assignment.service.SubscriptionService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/api/subscription")
@AllArgsConstructor
public class SubscriptionController {


    private final SubscriptionService subscriptionService;


    @PostMapping("/v1/create")
    public ResponseEntity<Subscription> createSubscription(@RequestBody SubscriptionDTO subscriptionDTO) {
        Subscription subscription = subscriptionService.createSubscription(subscriptionDTO);
        // Build the URI for the newly created resource
        URI location = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(subscription.getId())
                .toUri();

        // Return ResponseEntity with created status and location
        return ResponseEntity.created(location).body(subscription);
    }


    @GetMapping("/v1/data")
    public ResponseEntity<List<Subscription>> getAllPackage() {
        return ResponseEntity.ok(subscriptionService.getAllSubscription());
    }

}
