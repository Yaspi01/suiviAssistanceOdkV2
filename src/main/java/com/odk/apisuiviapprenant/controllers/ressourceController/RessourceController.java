package com.odk.apisuiviapprenant.controllers.ressourceController;

import com.odk.apisuiviapprenant.models.authers.RessourseApprenant;
import com.odk.apisuiviapprenant.models.authers.RessourseApprenantServiceImpl;
import com.odk.apisuiviapprenant.models.authers.UploadFile;
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
@RequestMapping("/api/")
public class RessourceController {

    @Autowired
    RessourceServiceImpl ressourceService;

    @Autowired
    RessourseApprenantServiceImpl ressourseApprenantService;

    @PostMapping("addUrl")
    Ressource addUrl(@RequestBody Ressource ressource){
        return ressourceService.addUrl(ressource);
    }

    /*
        Ressource apprenant
    */
    @PostMapping("addUrlApprenant")
    RessourseApprenant addUrlApprenant(@RequestBody RessourseApprenant apprenant){
        return ressourseApprenantService.addUrl(apprenant);
    }

    /*
        Toutes ressource uploader par un apprenant
    */
    @GetMapping("ressourceByApprenant/{id}")
    List<RessourseApprenant> ressourceByApprenant(@PathVariable("id") Long id){
        return ressourseApprenantService.ressourceApprenantByIdApprenant(id);
    }

    /*
        List ressouce uploader par formateur
    */
    @GetMapping("ressourceByFormateur/{id}")
    List<Ressource> ressourceByFormateur(@PathVariable("id") Long id){
        return ressourceService.ressourceByFormateur(id);
    }

    /*
        Upload ressource Formateur
    */
    @PostMapping("uploadRessourceFormateur")
    @ResponseBody
    Ressource uploadRessourceFormateur(Ressource ressource, @RequestParam("file") MultipartFile file) throws IOException {
        String fileName = StringUtils.cleanPath(file.getOriginalFilename());
        ressource.setPdf(fileName);

        String uploadDir = "src/main/resources/files/";
        UploadFile.saveFile(uploadDir, fileName, file);
        return ressourceService.addPdf(ressource);
    }

    /*
        Upload des ressource apprenant
    */
    @PostMapping("uploadRessource")
    @ResponseBody
    RessourseApprenant uploadRessource(RessourseApprenant ressourseApprenant, @RequestParam("file") MultipartFile file) throws IOException {
        String fileName = StringUtils.cleanPath(file.getOriginalFilename());
        ressourseApprenant.setPdf(fileName);

        String uploadDir = "src/main/resources/files/";
        UploadFile.saveFile(uploadDir, fileName, file);
        return ressourseApprenantService.addPdf(ressourseApprenant);
    }

    /*
        Ressource par apprenant envoyer par formateur
    */
    @GetMapping("ressourceSendByFormateurToApprenant/{id}")
    List<Ressource> ressourceSendByFormateurToApprenant(@PathVariable("id") Long id){
        return ressourceService.ressourceByApprenant(id);
    }
}
