package com.assignment.sub_assignment.service;

import com.assignment.sub_assignment.dto.PackageDTO;
import com.assignment.sub_assignment.entity.Offering;
import com.assignment.sub_assignment.entity.Package;
import com.assignment.sub_assignment.repository.PackageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PackageService {

    @Autowired
    private PackageRepository packageRepository;


    public Package createPackage(PackageDTO packageDTO) {
        Package pk = new Package();
        pk.setName(packageDTO.getName());
        pk.setDescription(packageDTO.getDescription());
        return packageRepository.save(pk);
    }

    public List<Package> getAllPackage() {
        return packageRepository.findAll();
    }
}
