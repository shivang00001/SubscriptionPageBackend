package com.assignment.sub_assignment.repository;

import com.assignment.sub_assignment.entity.SubscriptionOffering;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SubscriptionOfferingRepository extends JpaRepository<SubscriptionOffering, Long> {
}
