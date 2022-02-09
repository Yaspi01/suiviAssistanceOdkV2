package com.odk.apisuiviapprenant.service.apprenantService;

import com.odk.apisuiviapprenant.models.apprenantModel.Apprenant;

import java.util.List;

public interface ApprenantService {
    Apprenant addApprenant(Apprenant apprenant);
    List<Apprenant> allAprenants();
    Apprenant apprenantById(Long id);
    void deleteApprenant(Long id);
    Apprenant updateApprenant(Apprenant apprenant, Long id);
    Apprenant authentification(String login, String motDePasse);
    void restaureAppre(Long id);
}
