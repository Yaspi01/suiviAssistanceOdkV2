package com.odk.apisuiviapprenant.service.matiereService;

import com.odk.apisuiviapprenant.models.matiereModel.Matiere;
import com.odk.apisuiviapprenant.repositories.matiereRepository.MatiereRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
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
        return matiereRepository.findById(id).get();
    }

    @Override
    public Matiere updateMatiere(Matiere matiere, Long id) {
        Matiere matiereFound = matiereRepository.findById(id).get();
        matiereFound.setNom_matiere(matiere.getNom_matiere());
        return matiereRepository.save(matiere);
    }

    public byte[] getPhoto(Long id) throws IOException {
        Matiere matiere = matiereRepository.getById(id);
        String icoPhoto = matiere.getPhoto();
        File file = new File("src/main/resources/files/"+icoPhoto);
        Path path = Paths.get(file.toURI());
        return Files.readAllBytes(path);
    }
}
