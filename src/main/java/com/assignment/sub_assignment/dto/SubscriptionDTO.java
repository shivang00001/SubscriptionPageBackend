package com.assignment.sub_assignment.dto;

import com.assignment.sub_assignment.entity.Subscription;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class SubscriptionDTO {
    private Long id;
    private String name;
    private Double cost;
    private String description;
    private Boolean support;

    public SubscriptionDTO(Subscription subscription, boolean active) {
        this.id = subscription.getId();
        this.name = subscription.getName();
        this.cost = subscription.getCost();
        this.description = subscription.getDescription();
        this.support = active;
    }
}
