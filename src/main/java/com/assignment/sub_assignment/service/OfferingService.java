package com.assignment.sub_assignment.service;

import com.assignment.sub_assignment.dto.OfferingDTO;
import com.assignment.sub_assignment.entity.Offering;
import com.assignment.sub_assignment.entity.Package;
import com.assignment.sub_assignment.exceptions.PackageNotFoundException;
import com.assignment.sub_assignment.repository.OfferingRepository;
import com.assignment.sub_assignment.repository.PackageRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class OfferingService {


    private final OfferingRepository offeringRepository;
    private final PackageRepository packageRepository;

    public Offering createOffering(OfferingDTO offeringDTO) {

        Optional<Package> packageE = packageRepository.findById(offeringDTO.getPackageId());

        if (packageE.isPresent()) {
            Offering offering = new Offering();
            offering.setName(offeringDTO.getName());
            offering.setDescription(offeringDTO.getDescription());
            offering.setPkg(packageE.get());
            return offeringRepository.save(offering);
        }
        throw new PackageNotFoundException(String.format("Package not found %s", offeringDTO.getPackageId()));
    }

    public List<Offering> getAllOffering() {
        return offeringRepository.findAll();
    }
}
