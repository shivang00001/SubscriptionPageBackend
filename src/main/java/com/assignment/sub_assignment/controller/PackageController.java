package com.assignment.sub_assignment.controller;

import com.assignment.sub_assignment.dto.PackageDTO;
import com.assignment.sub_assignment.entity.Package;
import com.assignment.sub_assignment.service.PackageService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import java.net.URI;
import java.util.List;


@RequestMapping("/api/package")
@RestController
@AllArgsConstructor
public class PackageController {

    private final PackageService packageService;

    @PostMapping("/v1/create")
    public ResponseEntity<Package> createOffering(@RequestBody PackageDTO packageDTO) {
        Package aPackage = packageService.createPackage(packageDTO);
        // Build the URI for the newly created resource
        URI location = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(aPackage.getId())
                .toUri();

        // Return ResponseEntity with created status and location
        return ResponseEntity.created(location).body(aPackage);
    }


    @GetMapping("/v1/data")
    public ResponseEntity<List<Package>> getAllPackage() {
        return ResponseEntity.ok(packageService.getAllPackage());
    }

}
