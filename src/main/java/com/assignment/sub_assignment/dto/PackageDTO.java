package com.assignment.sub_assignment.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class PackageDTO {
    private Long id;
    private String name;
    private String description;
    private List<OfferingDTO> offeringDTOList;
}