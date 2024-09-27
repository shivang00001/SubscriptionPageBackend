package com.assignment.sub_assignment.dto;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class OfferingDTO {
    private Long id;
    private String name;
    private String description;
    private Long packageId;
}