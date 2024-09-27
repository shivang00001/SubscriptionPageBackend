package com.assignment.sub_assignment.dto;

import com.assignment.sub_assignment.entity.Subscription;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;
import java.util.Map;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class SubscriptionOfferingData {

    private String name;
    private List<SubscriptionDTO> subsriptions;
}
