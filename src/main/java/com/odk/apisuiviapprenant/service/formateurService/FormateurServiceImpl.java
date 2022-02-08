package com.odk.apisuiviapprenant.service.formateurService;

import com.odk.apisuiviapprenant.models.formateurModel.Formateur;
import com.odk.apisuiviapprenant.repositories.formateurRepository.FormateurRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FormateurServiceImpl implements FormateurService{

    @Autowired
    FormateurRepository formateurRepository;

    @Override
    public Formateur addFormateur(Formateur formateur) {
        return formateurRepository.save(formateur);
    }

    @Override
    public List<Formateur> allFormateur() {
        return formateurRepository.findAll();
    }

    @Override
    public Formateur formateurById(Long id) {
        return formateurRepository.findById(id).get();
    }
}
