package com.assignment.sub_assignment.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class PackageSubscriptionDTO {

    private String name;
    private List<SubscriptionOfferingData> data;

}
