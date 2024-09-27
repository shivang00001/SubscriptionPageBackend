package com.assignment.sub_assignment.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class SubscriptionOffering {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    @ManyToOne
    @JoinColumn(name = "subId") // Foreign key column in the Offering table
    private Subscription subscription;


    @ManyToOne
    @JoinColumn(name = "offId") // Foreign key column in the Offering table
    private Offering offering;

    private boolean isActive;
}
