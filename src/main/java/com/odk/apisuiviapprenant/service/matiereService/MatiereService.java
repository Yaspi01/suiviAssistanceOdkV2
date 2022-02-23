package com.odk.apisuiviapprenant.service.matiereService;

import com.odk.apisuiviapprenant.models.matiereModel.Matiere;

import java.util.List;

public interface MatiereService {
    Matiere addMatiere(Matiere matiere);
    List<Matiere> allMatiere();
    Matiere matiereById(Long id);
    Matiere updateMatiere(Matiere matiere, Long id);

}
