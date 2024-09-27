package com.assignment.sub_assignment.service;

import com.assignment.sub_assignment.dto.AllPackageDTO;
import com.assignment.sub_assignment.dto.PackageSubscriptionDTO;
import com.assignment.sub_assignment.dto.SubscriptionDTO;
import com.assignment.sub_assignment.dto.SubscriptionOfferingData;
import com.assignment.sub_assignment.entity.Offering;
import com.assignment.sub_assignment.entity.Package;
import com.assignment.sub_assignment.entity.Subscription;
import com.assignment.sub_assignment.entity.SubscriptionOffering;
import com.assignment.sub_assignment.exceptions.PackageNotFoundException;
import com.assignment.sub_assignment.repository.PackageRepository;
import com.assignment.sub_assignment.repository.SubscriptionOfferingRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
@AllArgsConstructor
public class CommonService {


    private final PackageRepository packageRepository;
    private final SubscriptionOfferingRepository subscriptionOfferingRepository;

    public AllPackageDTO getAllPackages(Long packageId) {

        List<Package> packageList;

        if (Objects.isNull(packageId)) {
            packageList = packageRepository.findAll();
        } else {
            Optional<Package> packageOptional = packageRepository.findById(packageId);
            if (packageOptional.isEmpty())
                throw new PackageNotFoundException(String.format("Package not found %s", packageId));
            packageList = Collections.singletonList(packageOptional.get());
        }


        List<SubscriptionOffering> subscriptionOfferingList = subscriptionOfferingRepository.findAll();
        List<PackageSubscriptionDTO> packageSubscriptionList = new ArrayList<>();

        Map<Long, List<SubscriptionDTO>> offeringSubScriptionMap = new HashMap<>();
        for (SubscriptionOffering subscriptionOffering : subscriptionOfferingList) {

            Subscription subscription = subscriptionOffering.getSubscription();
            Offering offering = subscriptionOffering.getOffering();

            if (offeringSubScriptionMap.containsKey(offering.getId())) {
                List<SubscriptionDTO> oldSub = offeringSubScriptionMap.get(offering.getId());
                oldSub.add(new SubscriptionDTO(subscription, subscriptionOffering.isActive()));
                offeringSubScriptionMap.put(offering.getId(), oldSub);
            } else {
                List<SubscriptionDTO> subscriptionList = new ArrayList<>();
                subscriptionList.add(new SubscriptionDTO(subscription, subscriptionOffering.isActive()));
                offeringSubScriptionMap.put(offering.getId(), subscriptionList);
            }
        }

        for (Package p :  packageList) {
            PackageSubscriptionDTO packageSubscriptionDTO = new PackageSubscriptionDTO();
            packageSubscriptionDTO.setName(p.getName());
            List<SubscriptionOfferingData> data = makeOfferSubscriptionMapData(offeringSubScriptionMap, p.getOfferings());
            packageSubscriptionDTO.setData(data);
            packageSubscriptionList.add(packageSubscriptionDTO);
        }
        AllPackageDTO allPackageDTO = new AllPackageDTO();
        allPackageDTO.setPackageSubscriptionDTOList(packageSubscriptionList);
        return allPackageDTO;
    }

    private List<SubscriptionOfferingData> makeOfferSubscriptionMapData(Map<Long, List<SubscriptionDTO>> offeringSubScriptionMap,
                                                                        List<Offering> offerings) {
        List<SubscriptionOfferingData> subscriptionOfferingData = new ArrayList<>();
        for (Offering offering : offerings) {
            SubscriptionOfferingData sod = new SubscriptionOfferingData();
            sod.setName(offering.getName());
            sod.setSubsriptions(offeringSubScriptionMap.get(offering.getId()));
            subscriptionOfferingData.add(sod);
        }
        return subscriptionOfferingData;
    }
}
