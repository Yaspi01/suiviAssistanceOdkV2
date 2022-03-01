package com.odk.apisuiviapprenant.models.authers;

import com.odk.apisuiviapprenant.models.ressourceModel.Ressource;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

public interface RessourseApprenantService {
    RessourseApprenant addUrl(RessourseApprenant ressource);
    RessourseApprenant addPdf(RessourseApprenant ressource, MultipartFile file) throws IOException;
    List<RessourseApprenant> allRessource();
    List<RessourseApprenant> ressourceApprenantByIdApprenant(Long id);
}
