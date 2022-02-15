package com.odk.apisuiviapprenant.service.ressourceService;

import com.odk.apisuiviapprenant.models.ressourceModel.Ressource;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public interface RessourceService {
    Ressource addUrl(Ressource ressource);
    Ressource addPdf(Ressource ressource);
    List<Ressource> allRessource();
    Ressource ressourceUrlById(Long id);
    void ressourceByPdf(MultipartFile file);
    List<Ressource> ressourceByFormateur(Long id);
    List<Ressource> ressourceByApprenant(Long id);
}
