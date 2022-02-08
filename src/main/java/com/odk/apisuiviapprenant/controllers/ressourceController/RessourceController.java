package com.odk.apisuiviapprenant.controllers.ressourceController;

import com.odk.apisuiviapprenant.models.apprenantModel.Apprenant;
import com.odk.apisuiviapprenant.models.formateurModel.Formateur;
import com.odk.apisuiviapprenant.models.ressourceModel.Ressource;
import com.odk.apisuiviapprenant.service.ressourceService.RessourceServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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
}
