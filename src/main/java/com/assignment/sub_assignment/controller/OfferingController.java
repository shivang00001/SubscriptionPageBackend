package com.assignment.sub_assignment.controller;

import com.assignment.sub_assignment.dto.OfferingDTO;
import com.assignment.sub_assignment.entity.Offering;
import com.assignment.sub_assignment.service.OfferingService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/api/offering")
@AllArgsConstructor
public class OfferingController {

    private final OfferingService offeringService;

    @PostMapping("/v1/create")
    public ResponseEntity<Offering> createOffering(@RequestBody OfferingDTO offeringDTO) {
        Offering offering = offeringService.createOffering(offeringDTO);
        // Build the URI for the newly created resource
        URI location = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(offering.getId())
                .toUri();

        // Return ResponseEntity with created status and location
        return ResponseEntity.created(location).body(offering);
    }


    @GetMapping("/v1/data")
    public ResponseEntity<List<Offering>> getAllOffering() {
        return ResponseEntity.ok(offeringService.getAllOffering());
    }

}
