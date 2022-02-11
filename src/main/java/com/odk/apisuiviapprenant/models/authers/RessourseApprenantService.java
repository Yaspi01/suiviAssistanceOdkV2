package com.odk.apisuiviapprenant.models.authers;

import com.odk.apisuiviapprenant.models.ressourceModel.Ressource;

import java.util.List;

public interface RessourseApprenantService {
    RessourseApprenant addUrl(RessourseApprenant ressource);
    RessourseApprenant addPdf(RessourseApprenant ressource);
    List<RessourseApprenant> allRessource();
    List<RessourseApprenant> ressourceApprenantByIdApprenant(Long id);
}
