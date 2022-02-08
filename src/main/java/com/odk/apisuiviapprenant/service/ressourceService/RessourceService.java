package com.odk.apisuiviapprenant.service.ressourceService;

import com.odk.apisuiviapprenant.models.apprenantModel.Apprenant;
import com.odk.apisuiviapprenant.models.formateurModel.Formateur;
import com.odk.apisuiviapprenant.models.ressourceModel.Ressource;

import java.util.List;

public interface RessourceService {
    Ressource addUrl(Ressource ressource);
    Ressource addPdf();
    List<Ressource> allRessource();
    Ressource ressourceUrlById(Long id);
    Ressource ressourceByPdf();
    List<Ressource> ressourceByApprenant(Apprenant apprenant);
    List<Ressource> ressourceByFormateur(Formateur formateur);


}
