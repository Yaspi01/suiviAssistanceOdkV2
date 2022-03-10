package com.odk.apisuiviapprenant.service.briefService;

import com.odk.apisuiviapprenant.models.authers.UploadFile;
import com.odk.apisuiviapprenant.models.briefModel.Brief;
import com.odk.apisuiviapprenant.repositories.briefRepository.BriefRepository;
import com.odk.apisuiviapprenant.service.MailSenderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import javax.transaction.Transactional;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

@Service
public class BriefServiceImpl implements BriefService {

    @Autowired
    BriefRepository briefRepository;
    @Autowired
    MailSenderService senderService;

    @Transactional
    @Override
    public Brief addBrief(Brief brief, @RequestParam("file") MultipartFile file) throws IOException {
        String fileNamne = StringUtils.cleanPath(file.getOriginalFilename());
        brief.setPhoto(fileNamne);
        brief.getApprenant().setAssister(true);
        Brief bf = briefRepository.save(brief);

        /*String uploadDir = "src/main/resources/files/"+brief.getId();
        UploadFile.saveFile(uploadDir, fileNamne, file);
        senderService.sendSimpleEmail(brief.getApprenant().getEmail(),
                "Bonjour " + brief.getApprenant().getPrenom() + " "+
                        brief.getApprenant().getNom() + "\n"+
                        "Votre formateur vous a envoyer un brief sur " +brief.getType()
                + "\n" + "Connecter vous a votre compte pour plus d'informations http://localhost:4200"
                ,
                brief.getType());
         */

        return bf;
    }

    @Override
    public List<Brief> allBrief() {
        return briefRepository.findAll();
    }

    @Override
    public Brief briefById(Long id) {
        return briefRepository.findById(id).get();
    }

    @Override
    public List<Brief> findBriefByApprenant(Long id) {
        return briefRepository.findBriefByApprenant(id);
    }

    public Brief updateBrief(Brief brief, Long id){
        Brief briefFound = briefRepository.findById(id).get();
        briefFound.setDescription(brief.getDescription());
        briefFound.setType(brief.getType());
        briefFound.setPhoto(brief.getPhoto());
        briefFound.setDate(brief.getDate());
        briefFound.setFormateur(brief.getFormateur());
        briefFound.setApprenant(brief.getApprenant());
        briefFound.setEvaluation(brief.getEvaluation());
        briefFound.setRendu(brief.getRendu());
        return briefRepository.save(briefFound);
    }
    @Override
    public List<Brief> findBriefByFormateur(Long id) {
        return briefRepository.findBriefByFormateur(id);
    }

    public byte[] getPhoto(Long id) throws IOException {
        Brief brief = briefRepository.getById(id);
        String iconPhoto = brief.getPhoto();
        File file = new File("src/main/resources/files/"+brief.getId() +"/"+ iconPhoto);

        Path path = Paths.get(file.toURI());
        return Files.readAllBytes(path);
    }
}
