package com.assignment.sub_assignment.entity;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Setter
@Getter
@Entity
public class Package {
    // Getters and Setters
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private String description;

    @OneToMany(mappedBy = "pkg", cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonManagedReference
    private List<Offering> offerings = new ArrayList<>();


    public void addOffering(Offering offering) {
        offerings.add(offering);
        offering.setPkg(this); // Set the reference back to the package
    }

    public void removeOffering(Offering offering) {
        offerings.remove(offering);
        offering.setPkg(null); // Remove the reference back to the package
    }
}
