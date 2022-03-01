package com.odk.apisuiviapprenant.models.authers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@Service
public class RessourseApprenantServiceImpl implements RessourseApprenantService{

    @Autowired
    RessourseApprenantRepository ressourseApprenantRepository;

    @Override
    public RessourseApprenant addUrl(RessourseApprenant ressource) {
        return ressourseApprenantRepository.save(ressource);
    }

    @Override
    public RessourseApprenant addPdf(RessourseApprenant ressource, MultipartFile file) throws IOException {
        String fileName = StringUtils.cleanPath(file.getOriginalFilename());
        ressource.setPdf(fileName);
        RessourseApprenant res = ressourseApprenantRepository.save(ressource);
        String uploadDir = "src/main/resources/files/"+ressource.getId();
        UploadFile.saveFile(uploadDir, fileName, file);
        return res;
    }

    @Override
    public List<RessourseApprenant> allRessource() {
        return ressourseApprenantRepository.findAll();
    }

    @Override
    public List<RessourseApprenant> ressourceApprenantByIdApprenant(Long id) {
        return ressourseApprenantRepository.findRessourseApprenantByApprenant(id);
    }
}
