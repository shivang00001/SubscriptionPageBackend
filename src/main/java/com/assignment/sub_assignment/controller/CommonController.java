package com.assignment.sub_assignment.controller;

import com.assignment.sub_assignment.dto.AllPackageDTO;
import com.assignment.sub_assignment.service.CommonService;
import jakarta.websocket.server.PathParam;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/query")
@AllArgsConstructor
public class CommonController {

    private final CommonService commonService;

    @GetMapping("/v1/data")
    public ResponseEntity<AllPackageDTO> getAllPackages(@RequestParam(name = "packageId", required=false) Long packageId) {
        return ResponseEntity.ok(commonService.getAllPackages(packageId));
    }


}
