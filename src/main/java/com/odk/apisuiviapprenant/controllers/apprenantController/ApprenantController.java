package com.odk.apisuiviapprenant.controllers.apprenantController;

import com.odk.apisuiviapprenant.models.apprenantModel.Apprenant;
import com.odk.apisuiviapprenant.service.apprenantService.ApprenantServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/apprenants")
public class ApprenantController {

    @Autowired
    ApprenantServiceImpl apprenantService;

    @PostMapping("/ajoutApprenant")
    Apprenant ajoutApprenant(@RequestBody Apprenant apprenant){
        return apprenantService.addApprenant(apprenant);
    }

    @GetMapping("/allAprenant")
    List<Apprenant> allAprenant(){
        return apprenantService.allAprenants();
    }

    @GetMapping("/apprenantById/{id}")
    Apprenant apprenantById(@PathVariable("id")Long id){
        return apprenantService.apprenantById(id);
    }

    @DeleteMapping("/deleteApprenant/{id}")
    void deleteApprenant(@PathVariable("id")Long id){
        apprenantService.deleteApprenant(id);
    }

    @PutMapping("/updateApprenant/{id}")
    Apprenant updateApprenant(@RequestBody Apprenant apprenant, @PathVariable("id") Long id){
        return apprenantService.updateApprenant(apprenant, id);
    }

    @GetMapping("/login/{login}&{motDePass}")
    Apprenant connexion(@PathVariable("login") String login, @PathVariable("motDePass") String motDePasse){
        return apprenantService.authentification(login, motDePasse);
    }

    @DeleteMapping("restoreApprenant/{id}")
    void restoreApprenant(@PathVariable("id") Long id){
        apprenantService.restaureAppre(id);
    }
}
