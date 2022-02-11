package com.odk.apisuiviapprenant.controllers.ressourceController;

import com.odk.apisuiviapprenant.models.apprenantModel.Apprenant;
import com.odk.apisuiviapprenant.models.authers.UploadFile;
import com.odk.apisuiviapprenant.models.formateurModel.Formateur;
import com.odk.apisuiviapprenant.models.ressourceModel.Ressource;
import com.odk.apisuiviapprenant.service.ressourceService.RessourceServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/ressources")
public class RessourceController {

    @Autowired
    RessourceServiceImpl ressourceService;

    @PostMapping("/addUrl")
    Ressource addUrl(@RequestBody Ressource ressource){
        return ressourceService.addUrl(ressource);
    }

    @GetMapping("/ressourceByAndApprenant")
    List<Ressource> ressourceByAndApprenant(@RequestBody Apprenant apprenant){
        return ressourceService.ressourceByApprenant(apprenant);
    }

    @GetMapping("/ressourceByFormateur")
    List<Ressource> ressourceByFormateur(@RequestBody Formateur formateur){
        return ressourceService.ressourceByFormateur(formateur);
    }

    @PostMapping("/uploadRessource")
    @ResponseBody
    Ressource uploadRessource(Ressource ressource, @RequestParam("file") MultipartFile file) throws IOException {
        String fileName = StringUtils.cleanPath(file.getOriginalFilename());
        ressource.setPdf(fileName);

        String uploadDir = "src/main/resources/files/";
        UploadFile.saveFile(uploadDir, fileName, file);
        return ressourceService.addPdf(ressource);
    }
}
