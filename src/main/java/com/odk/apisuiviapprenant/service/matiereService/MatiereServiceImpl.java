package com.odk.apisuiviapprenant.service.matiereService;

import com.odk.apisuiviapprenant.models.matiereModel.Matiere;
import com.odk.apisuiviapprenant.repositories.matiereRepository.MatiereRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MatiereServiceImpl implements MatiereService{

    @Autowired
    MatiereRepository matiereRepository;

    @Override
    public Matiere addMatiere(Matiere matiere) {
        return matiereRepository.save(matiere);
    }

    @Override
    public List<Matiere> allMatiere() {
        return matiereRepository.findAll();
    }

    @Override
    public Matiere matiereById(Long id) {
        return matiereRepository.getById(id);
    }

    @Override
    public Matiere updateMatiere(Matiere matiere, Long id) {
        Matiere matiereFound = matiereRepository.getById(id);
        matiereFound.setNom_matiere(matiere.getNom_matiere());
        return matiereRepository.save(matiere);
    }
}