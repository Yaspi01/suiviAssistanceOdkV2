package com.odk.apisuiviapprenant.models.authers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RessourseApprenantServiceImpl implements RessourseApprenantService{

    @Autowired
    RessourseApprenantRepository ressourseApprenantRepository;

    @Override
    public RessourseApprenant addUrl(RessourseApprenant ressource) {
        return ressourseApprenantRepository.save(ressource);
    }

    @Override
    public RessourseApprenant addPdf(RessourseApprenant ressource) {
        return ressourseApprenantRepository.save(ressource);
    }

    @Override
    public List<RessourseApprenant> allRessource() {
        return ressourseApprenantRepository.findAll();
    }

    @Override
    public List<RessourseApprenant> ressourceApprenantByIdApprenant(Long id) {
        return ressourseApprenantRepository.findRessourseApprenantByApprenant(id);
    }
}
