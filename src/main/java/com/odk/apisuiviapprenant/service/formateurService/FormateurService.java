package com.odk.apisuiviapprenant.service.formateurService;

import com.odk.apisuiviapprenant.models.formateurModel.Formateur;

import java.util.List;

public interface FormateurService {
    Formateur addFormateur(Formateur formateur);
    List<Formateur> allFormateur();
    Formateur formateurById(Long id);
}
