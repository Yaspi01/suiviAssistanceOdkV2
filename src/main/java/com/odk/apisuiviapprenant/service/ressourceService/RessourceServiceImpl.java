package com.odk.apisuiviapprenant.service.ressourceService;

import com.odk.apisuiviapprenant.models.apprenantModel.Apprenant;
import com.odk.apisuiviapprenant.models.formateurModel.Formateur;
import com.odk.apisuiviapprenant.models.ressourceModel.Ressource;
import com.odk.apisuiviapprenant.repositories.ressourceRepository.RessourceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.transaction.Transactional;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.List;

@Service
public class RessourceServiceImpl implements RessourceService {

    @Autowired
    RessourceRepository ressourceRepository;

    @Override
    public Ressource addUrl(Ressource ressource) {
        return ressourceRepository.save(ressource);
    }

    @Override
    public Ressource addPdf(Ressource ressource) {
        return ressourceRepository.save(ressource);
    }

    @Override
    public List<Ressource> allRessource() {
        return null;
    }

    @Override
    public Ressource ressourceUrlById(Long id) {
        return null;
    }

    @Transactional
    @Override
    public void ressourceByPdf(MultipartFile file) {
        try {
            if(file.isEmpty()){
                throw new Exception("Ce fichier n'existe pas");
            }
            Path path = Paths.get("src/main/resources/files/"+file.getOriginalFilename());
            Files.copy(file.getInputStream(), path, StandardCopyOption.REPLACE_EXISTING);
        }catch (Exception e){
            e.printStackTrace();
        }
    }



    @Override
    public List<Ressource> ressourceByFormateur(Long id) {
        return ressourceRepository.ressourceByFormateur(id);
    }

    @Override
    public List<Ressource> ressourceByApprenant(Long id) {
        return ressourceRepository.ressourceByApprenant(id);
    }


}
