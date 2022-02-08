package com.odk.apisuiviapprenant.service.ressourceService;

import com.odk.apisuiviapprenant.models.apprenantModel.Apprenant;
import com.odk.apisuiviapprenant.models.formateurModel.Formateur;
import com.odk.apisuiviapprenant.models.ressourceModel.Ressource;
import com.odk.apisuiviapprenant.repositories.ressourceRepository.RessourceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RessourceServiceImpl implements RessourceService {

    @Autowired
    RessourceRepository ressourceRepository;

    @Override
    public Ressource addUrl(Ressource ressource) {
        return ressourceRepository.save(ressource);
    }

    @Override
    public Ressource addPdf() {
        return null;
    }

    @Override
    public List<Ressource> allRessource() {
        return null;
    }

    @Override
    public Ressource ressourceUrlById(Long id) {
        return null;
    }

    @Override
    public Ressource ressourceByPdf() {
        return null;
    }

    @Override
    public List<Ressource> ressourceByApprenant(Apprenant apprenant) {
        return ressourceRepository.ressourceApprenant(apprenant);
    }

    @Override
    public List<Ressource> ressourceByFormateur(Formateur formateur) {
        return ressourceRepository.ressourceByFormateur(formateur);
    }


}
